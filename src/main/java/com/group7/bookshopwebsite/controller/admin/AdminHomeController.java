package com.group7.bookshopwebsite.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminHomeController {
    

    @GetMapping
    public String home(){
        return "admin/index";
    }
}
