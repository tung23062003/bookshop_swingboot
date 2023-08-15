package com.group7.bookshopwebsite.controller.admin;

import com.group7.bookshopwebsite.entity.Category;
import com.group7.bookshopwebsite.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/categories_management")
public class AdminCategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public String getAllCategories(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 5; // Kích thước trang bạn muốn hiển thị
        Page<Category> categoryPage = categoryService.getAllCategories(PageRequest.of(page-1, pageSize));

        model.addAttribute("categories", categoryPage.getContent());
        model.addAttribute("currentPage", categoryPage.getNumber());
        model.addAttribute("totalPages", categoryPage.getTotalPages());

        return "admin/category";
    }

    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category_add_or_update";
    }

    @PostMapping("/add_or_update")
    public String addOrUpdateCategory(@ModelAttribute Category category) {
        if (category.getId() != null) {
            // Có ID -> Cập nhật
            categoryService.updateCategory(category.getId(), category);
        } else {
            // Không có ID -> Thêm mới
            categoryService.addCategory(category);
        }
        return "redirect:/admin/categories_management";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(Model model,@PathVariable Long id) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "admin/category_add_or_update";
    }
    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/admin/categories_management";
    }
}