package com.group7.bookshopwebsite.controller.admin;

import com.group7.bookshopwebsite.controller.common.BaseController;
import com.group7.bookshopwebsite.entity.Contact;
import com.group7.bookshopwebsite.service.ContactService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/contacts")
public class AdminContactController extends BaseController {
    private final ContactService contactService;

    @GetMapping
    public String adminContacts(Model model,
                                @RequestParam(name = "page", defaultValue = "1") int page,
                                @RequestParam(name = "sort_by",defaultValue = "newest") String sortBy){

        int pageSize = 4;
        Pageable pageable = PageRequest.of(page-1,pageSize);
        Page<Contact> contacts = contactService.getContactsPage(sortBy,pageable);
        model.addAttribute("contacts",contacts);
        model.addAttribute("totalPages",contacts.getTotalPages());
        model.addAttribute("currentPage",contacts.getNumber());
        model.addAttribute("sortBy",sortBy);

        return "/admin/contacts";
    }


    @GetMapping("/response/{id}")
    public String response(@PathVariable Long id){
        return "admin/contact_response";
    }


}
