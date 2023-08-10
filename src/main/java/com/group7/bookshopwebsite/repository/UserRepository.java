package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods if needed
}
