package xyz.crearts.money.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConfigurationProperties(prefix = "config")
public class Config {
    private String defaultCurrency;
    private String openexchangeratesKey;


    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getOpenexchangeratesKey() {
        return openexchangeratesKey;
    }

    public void setOpenexchangeratesKey(String openexchangeratesKey) {
        this.openexchangeratesKey = openexchangeratesKey;
    }
}
