package com.example.clothstore.clothstore.controller;

import com.example.clothstore.clothstore.entity.Category;
import com.example.clothstore.clothstore.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping("/add-category")
    public Category postCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/delete-category")
    public void removeCategory(Long id) {
        categoryService.deleteCategory(id);
    }
}
