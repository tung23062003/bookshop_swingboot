package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContaining(String keyword, Pageable pageable);
    Book findByTitle(String title);

    Page<Book> findByCategory(Optional<Category> category, Pageable pageable);


    Page<Book> findByCategory_IdAndTitleContaining(Long categoryId, String keyword, Pageable pageable);


}
