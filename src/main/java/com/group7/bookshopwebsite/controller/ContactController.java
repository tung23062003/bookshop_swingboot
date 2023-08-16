package com.group7.bookshopwebsite.controller;

import com.group7.bookshopwebsite.entity.Contact;
import com.group7.bookshopwebsite.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;
    @GetMapping
    public String getContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "user/contact";
    }

    @PostMapping("/submit")
    public String submitContactForm(@ModelAttribute Contact contact, Model model) {
        Contact savedContact = contactService.saveContact(contact);
        model.addAttribute("success", true);
        model.addAttribute("contact", savedContact);
        return "redirect:/contact?success=true";
    }
}
