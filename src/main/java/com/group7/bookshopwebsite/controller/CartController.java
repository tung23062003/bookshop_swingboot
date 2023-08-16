package com.group7.bookshopwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public String getCartPage(){
        return "user/cart";
    }

    @GetMapping("/checkout")
    public String getCheckOut(){
        return "user/checkout";
    }
}
