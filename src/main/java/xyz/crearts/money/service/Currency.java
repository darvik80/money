package xyz.crearts.money.service;

import lombok.Data;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import xyz.crearts.money.model.Config;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Currency {
    private Config config;

    @Data
    public static class Response {
        private Map<String, Double> rates;
    }

    private static final String uri = "https://openexchangerates.org/api/historical";
    private RestTemplate restTemplate;

    public Currency(Config config, RestTemplateBuilder restTemplateBuilder) {
        this.config = config;
        this.restTemplate = restTemplateBuilder.build();
    }

    public Double getAmount(String symbol) {
        return getAmount(LocalDate.now(), config.getDefaultCurrency(), symbol);
    }

    public Double getAmount(LocalDate date, String base, String symbol) {
        try {
            Map<String, Double> res = this.getAmounts(date, base, symbol);

            return res.getOrDefault(symbol, 0.0);
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }

        return 0.0;
    }

    public Map<String, Double> getAmounts(LocalDate date, String base, String... symbols) throws URISyntaxException {
        String s = Stream.of(symbols).collect(Collectors.joining( "," ));

        if (!base.equals("USD")) {
            if (s.length() > 0) {
                s += ",";
            }
            s += base;
        }

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance().uri(new URI(uri))
                .path("/"+DateTimeFormatter.ISO_LOCAL_DATE.format(date)+".json")
                .queryParam("app_id", config.getOpenexchangeratesKey())
                //.queryParam("base", base)
                .queryParam("symbols", s);

        Response response = restTemplate.getForObject(builder.build().toUri(), Response.class);

        if (base.equals("USD")) {
            return response.getRates();
        }

        Map<String, Double> result = new HashMap<>();

        Double baseCur = response.getRates().get(base);
        response.getRates().forEach((k, v) -> result.put(k, v/baseCur ));

        return result;
    }

}
