package com.group7.bookshopwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookSearchDTO {
    private Long categoryId;
    private String keyword;
    // Các thuộc tính tìm kiếm khác (nếu có)
    // Getter và Setter
}

