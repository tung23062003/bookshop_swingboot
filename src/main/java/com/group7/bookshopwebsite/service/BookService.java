package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.dto.BookSearchDTO;
import com.group7.bookshopwebsite.dto.UserSearchDTO;
import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface BookService {

    void addBook(Book book, MultipartFile coverImage);

    void editBook(Book book, MultipartFile coverImage);

    void deleteBook(Long id);

    Book getBookById(Long id);
    Book getBookByName(String name);

    Page<Book> searchBooks(BookSearchDTO search, Pageable pageable);
    Page<Book> searchBooksUser(UserSearchDTO search, Pageable pageable);

    Page<Book> getAllBooksForUsers(Pageable pageable);

    List<Book> getTop4BestSeller();
    List<Book> findAllOrderByCreatedDate();

    Set<Book> getFavoriteBooksByUserId(Long id);

    Long countBook();
}
