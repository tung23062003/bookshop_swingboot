package com.group7.bookshopwebsite.controller;

import com.group7.bookshopwebsite.controller.common.BaseController;
import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@AllArgsConstructor
@Controller

public class HomeController extends BaseController {

    private BookService bookService;

    @GetMapping("/")
    String getUserHomePage(Model model){

        List<Book> top4BestSeller =bookService.getTop4BestSeller();
        model.addAttribute("top4BestSeller",top4BestSeller);
        List<Book> newProducts =bookService.findAllOrderByCreatedDate();
        model.addAttribute("newProducts",newProducts);
        return "user/index";
    }
}
