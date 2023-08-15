package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Custom query methods if needed
}
