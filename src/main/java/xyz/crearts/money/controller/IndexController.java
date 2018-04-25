package xyz.crearts.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.crearts.money.repository.CurrencyRepository;

/**
 * @author ivan.kishchenko
 */
@Controller
public class IndexController {
    CurrencyRepository currencyRepository;


    IndexController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/")
    public String indexAction(Model model) {
        model.addAttribute("currencies", this.currencyRepository.findAll());

        return "index";
    }
}
