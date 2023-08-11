package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    Set<Book> getFavoriteBooks(Long userId);
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long userId);
}
