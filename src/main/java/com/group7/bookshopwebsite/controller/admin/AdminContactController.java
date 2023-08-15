package com.group7.bookshopwebsite.controller.admin;

import com.group7.bookshopwebsite.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/contacts_management")
public class AdminContactController {
    private final ContactService contactService;

    @GetMapping
    public String getContactsPage(){
        return "/admin/contacts";
    }


}
