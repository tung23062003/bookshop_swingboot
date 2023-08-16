package com.group7.bookshopwebsite.controller;

import com.group7.bookshopwebsite.controller.common.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/wishlist")
public class WishListController extends BaseController {

    @GetMapping
    public String getWishList(){
        return "user/wishlist";
    }
}
