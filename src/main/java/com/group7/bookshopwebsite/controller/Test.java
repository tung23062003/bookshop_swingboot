package com.group7.bookshopwebsite.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@AllArgsConstructor
@Controller
public class Test {

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("message", "Hello World");
		return "admin/books";
	}

}
