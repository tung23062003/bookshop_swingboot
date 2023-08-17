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

    Page<Book> findByCategoryIdAndTitleContainingOrderBySalePriceDesc(Long categoryId, String keyword, Pageable pageable);
    Page<Book> findByCategoryIdAndTitleContainingOrderBySalePriceAsc(Long categoryId, String keyword, Pageable pageable);
    Page<Book> findByCategoryIdAndTitleContainingOrderByCreatedAtAsc(Long categoryId, String keyword, Pageable pageable);
    Page<Book> findByCategoryIdAndTitleContainingOrderByCreatedAtDesc(Long categoryId, String keyword, Pageable pageable);

    Page<Book> findByCategoryId(Long categoryId, Pageable pageable);

    Page<Book> findByCategoryIdAndTitleContaining(Long categoryId, String keyword, Pageable pageable);

    Page<Book> findByTitleContainingOrderByCreatedAtAsc(String title, Pageable pageable);
    Page<Book> findByTitleContainingOrderByCreatedAtDesc(String title, Pageable pageable);
    Page<Book> findByTitleContainingOrderBySalePriceAsc(String title, Pageable pageable);
    Page<Book> findByTitleContainingOrderBySalePriceDesc(String title, Pageable pageable);



}
