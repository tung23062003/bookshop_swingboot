package com.group7.bookshopwebsite.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {
    private List<CartItemDTO> items;
    private Double totalPrice;
}
