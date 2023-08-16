package com.group7.bookshopwebsite.service;


import com.group7.bookshopwebsite.dto.BookSearchDTO;
import com.group7.bookshopwebsite.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    void addBook(Book book, MultipartFile coverImage);

    void editBook(Book book, MultipartFile coverImage);

    void deleteBook(Long id);

    Book getBookById(Long id);
    Book getBookByName(String name);
    List<Book> getAllBooks();

    Page<Book> searchBooks(BookSearchDTO search, Pageable pageable);

}
