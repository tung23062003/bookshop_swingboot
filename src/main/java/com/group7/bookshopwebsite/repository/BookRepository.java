package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContaining(String keyword, Pageable pageable);
    Book findByTitle(String title);
    Page<Book> findByAuthorContaining(String keyword, Pageable pageable);

    Page<Book> findByCategory(Optional<Category> category, Pageable pageable);

    Page<Book> findBySalePriceLessThan(double price, Pageable pageable);

    Page<Book> findByOrderByBuyCountDesc(Pageable pageable);

    Page<Book> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Page<Book> findByPublishedDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Book> findBooksByCategoryAndSalePriceLessThan(Category category, double price, Pageable pageable);

    Page<Book> findBooksByTitleContainingOrAuthorContaining(String titleKeyword, String authorKeyword, Pageable pageable);
    Page<Book> findByCategory_IdAndTitleContaining(Long categoryId, String keyword, Pageable pageable);
}
