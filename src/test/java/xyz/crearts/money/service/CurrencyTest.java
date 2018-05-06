package xyz.crearts.money.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import xyz.crearts.money.model.Config;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(Currency.class)
@EnableConfigurationProperties(Config.class)
@ActiveProfiles("test")
public class CurrencyTest {
    @Autowired
    private Currency service;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    private String body;

    @Before
    public void setUp() throws Exception {
        Map<String, Double> rates = new HashMap<String, Double>() {{
            put("VND", 1.0);
            put("RUB", 4.0);

        }};
        Currency.Response response = new Currency.Response();
        response.setRates(rates);

        body = objectMapper.writeValueAsString(response);


        this.server.expect(requestTo("https://openexchangerates.org/api/historical/2018-05-05.json?app_id=8c4a6b80722a4ff3bf0f325574cf93c2&symbols=VND,RUB"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(body, MediaType.APPLICATION_JSON));

        this.server.expect(requestTo("https://openexchangerates.org/api/historical/2018-05-05.json?app_id=8c4a6b80722a4ff3bf0f325574cf93c2&symbols=RUB,VND"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(body, MediaType.APPLICATION_JSON));

        this.server.expect(requestTo("https://openexchangerates.org/api/historical/2018-05-05.json?app_id=8c4a6b80722a4ff3bf0f325574cf93c2&symbols=RUB,VND"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(body, MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAmounts() throws Exception {

        Map<String, Double> result = service.getAmounts(LocalDate.of(2018,5,5), "USD", "VND", "RUB");
        assertEquals(result.get("VND"), Double.valueOf(1.0));
        assertEquals(result.get("RUB"), Double.valueOf(4.0));
        assertEquals(result.size(), 2);

        result = service.getAmounts(LocalDate.of(2018,5,5), "VND", "RUB");
        assertEquals(result.get("VND"), Double.valueOf(1.0));
        assertEquals(result.get("RUB"), Double.valueOf(4.0));
        assertEquals(result.size(), 2);

        Double res = service.getAmount(LocalDate.of(2018,5,5), "VND", "RUB");
        assertEquals(res, Double.valueOf(4.0));
    }
}
