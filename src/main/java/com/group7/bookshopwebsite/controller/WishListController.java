package com.group7.bookshopwebsite.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/wishlist")
public class WishListController {

    @GetMapping
    public String getWishList(){
        return "user/wishlist";
    }
}
