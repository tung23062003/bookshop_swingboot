package com.group7.bookshopwebsite.controller.admin;

import com.group7.bookshopwebsite.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/books_management")
public class BookController {

    private final BookService bookService;

}
