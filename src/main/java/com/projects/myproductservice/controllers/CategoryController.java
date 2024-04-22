package com.projects.myproductservice.controllers;

import com.projects.myproductservice.models.Category;
import com.projects.myproductservice.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        return optional.get();
    }
}
