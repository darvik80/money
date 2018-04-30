package xyz.crearts.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.entity.Category;
import xyz.crearts.money.repository.CashFlowRepository;
import xyz.crearts.money.repository.CategoryRepository;
import xyz.crearts.money.repository.CurrencyRepository;

/**
 * @author ivan.kishchenko
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController {
    @GetMapping({"/", ""})
    public String indexAction() {
        return "index";
    }

    @GetMapping("/categories")
    public String categoriesAction() {
        return "categories";
    }

    @GetMapping("/lab")
    public String labAction() {

        return "lab";
    }
}
