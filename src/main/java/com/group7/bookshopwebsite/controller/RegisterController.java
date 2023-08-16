package com.group7.bookshopwebsite.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {
    @GetMapping
    public String getRegisterPage(){
        return "user/register";
    }
}
