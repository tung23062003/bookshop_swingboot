package com.group7.bookshopwebsite.controller.admin;

import com.group7.bookshopwebsite.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/contacts_management")
public class AdminContactController {

    private final ContactService contactService;

    @Autowired
    public AdminContactController(ContactService contactService) {
        this.contactService = contactService;
    }

}
