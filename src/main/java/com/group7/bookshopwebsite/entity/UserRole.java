package com.group7.bookshopwebsite.entity;

import com.group7.bookshopwebsite.entity.composite_key.OrderDetailId;
import com.group7.bookshopwebsite.entity.composite_key.UserRoleId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(UserRoleId.class)
@Table(name = "users_roles")
public class UserRole {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Getters and setters
}