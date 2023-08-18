package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> findByOrderByCreatedAtDesc(Pageable pageable);
    Page<Contact> findByOrderByCreatedAtAsc(Pageable pageable);
}
