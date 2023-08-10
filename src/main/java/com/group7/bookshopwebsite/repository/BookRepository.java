package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query methods if needed
}
