package com.group7.bookshopwebsite.entity.composite_key;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderDetailId implements Serializable {

    private Long order;
    private Long book;

    // Constructors, equals, hashcode methods, and other necessary logic
}
