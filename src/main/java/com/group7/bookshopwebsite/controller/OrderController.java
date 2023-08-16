package com.group7.bookshopwebsite.controller;

import com.group7.bookshopwebsite.controller.common.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController extends BaseController {

    @GetMapping
    public String getOrders(){
        return "user/orders_list";
    }
}
