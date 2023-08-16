package com.group7.bookshopwebsite.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@Controller

public class HomeController {

    @GetMapping("/home")

    String getUserHomePage(){

        return "user/index";
    }
}
