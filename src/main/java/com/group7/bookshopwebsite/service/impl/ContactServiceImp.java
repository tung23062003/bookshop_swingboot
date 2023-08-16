package com.group7.bookshopwebsite.service.impl;

import com.group7.bookshopwebsite.entity.Contact;
import com.group7.bookshopwebsite.repository.ContactRepository;
import com.group7.bookshopwebsite.service.ContactService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class ContactServiceImp implements ContactService {
    private ContactRepository contactRepository;
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
}
