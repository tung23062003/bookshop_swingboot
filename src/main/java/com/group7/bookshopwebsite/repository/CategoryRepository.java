package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query methods if needed
    Page<Category> findAll(Pageable pageable);
}
