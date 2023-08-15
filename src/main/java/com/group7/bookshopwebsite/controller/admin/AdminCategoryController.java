package com.group7.bookshopwebsite.controller.admin;

import com.group7.bookshopwebsite.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/categories_management")
public class AdminCategoryController {

    private final CategoryService categoryService;

}
