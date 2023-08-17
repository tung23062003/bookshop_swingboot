package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Role;
import com.group7.bookshopwebsite.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByFullNameContaining(String fullName, Pageable pageable);

    Page<User> findByCreatedAtAfter(Date date, Pageable pageable);

    Page<User> findAllByOrderByCreatedAtDesc(Pageable pageable);
    Page<User> findAllByOrderByCreatedAtAsc(Pageable pageable);

    User findByEmail(String email);
}
