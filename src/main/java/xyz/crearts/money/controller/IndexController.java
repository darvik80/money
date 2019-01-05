package xyz.crearts.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.crearts.money.exception.NotFoundException;
import xyz.crearts.money.model.Config;
import xyz.crearts.money.service.Currency;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ivan.kishchenko
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController {
    private Map<String, Object> config = new HashMap<>();
    private Currency currency;

    @ModelAttribute("config")
    public Map<String, Object> getConfig() {
        return config;
    }

    public IndexController(Config config, Currency currency) {
        this.config.put("defaultCurrency", config.getDefaultCurrency());
        this.config.put("RUB", currency.getAmount("RUB"));
    }

    @GetMapping({"/", ""})
    public String indexAction() {
        return "index";
    }

    @GetMapping("/categories")
    public String categoriesAction() {
        return "categories.page";
    }

    @GetMapping("/report")
    public String reportAction() {
        return "report.page";
    }
}