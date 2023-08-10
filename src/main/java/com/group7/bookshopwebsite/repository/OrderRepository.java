package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query methods if needed
}
