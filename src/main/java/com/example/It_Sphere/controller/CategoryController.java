package com.example.It_Sphere.controller;

import com.example.It_Sphere.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<String> addCategory(@RequestParam String category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@RequestParam String category, @PathVariable Long id) {
        return new ResponseEntity<>(categoryService.updateCategory(category, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return new ResponseEntity<>(categoryService.getAllCategories(page, size), HttpStatus.OK);
    }
}
