package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.UserRole;
import com.group7.bookshopwebsite.entity.composite_key.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

}
