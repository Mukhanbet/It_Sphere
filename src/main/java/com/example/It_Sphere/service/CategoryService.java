package com.example.It_Sphere.service;

import java.util.List;

public interface CategoryService {
    String addCategory(String category);
    void deleteCategory(Long id);
    String updateCategory(String category, Long id);
    List<String> getAllCategories(int page, int size);
}
