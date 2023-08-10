package com.group7.bookshopwebsite.entity.composite_key;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserRoleId implements Serializable {

    private Long user;
    private Long role;

    // Constructors, equals, hashcode methods, and other necessary logic
}
