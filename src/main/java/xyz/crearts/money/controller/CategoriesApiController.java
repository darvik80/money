package xyz.crearts.money.controller;

import org.springframework.web.bind.annotation.*;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.repository.CashFlowRepository;
import xyz.crearts.money.repository.CategoryRepository;

@RestController
@RequestMapping("/rest/category")
public class CategoriesApiController {
    private CategoryRepository categoryRepository;

    public CategoriesApiController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping({""})
    public Object flowsAction() {
        return categoryRepository.findAll();
    }
}
