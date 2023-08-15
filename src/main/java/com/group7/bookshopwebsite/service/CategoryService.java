package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<Category> getAllCategories(Pageable pageable);
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);
    void addCategory(Category category);
    void updateCategory(Long categoryId, Category updatedCategory);
    void deleteCategory(Long categoryId);


}
