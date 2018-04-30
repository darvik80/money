package xyz.crearts.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.crearts.money.entity.Category;
import xyz.crearts.money.repository.CategoryRepository;
import xyz.crearts.money.repository.CurrencyRepository;

/**
 * @author ivan.kishchenko
 */
@Controller
public class IndexController {
    private CurrencyRepository currencyRepository;
    private CategoryRepository categoryRepository;


    IndexController(CategoryRepository categoryRepository, CurrencyRepository currencyRepository) {
        this.categoryRepository = categoryRepository;
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/")
    public String indexAction(Model model) {
        model.addAttribute("currencies", this.currencyRepository.findAll());

        return "index";
    }

    @GetMapping("/categories")
    public String categoriesAction(Model model) {
        return "categories";
    }

    @GetMapping("/lab")
    public String labAction(Model model) {

        return "lab";
    }
}
