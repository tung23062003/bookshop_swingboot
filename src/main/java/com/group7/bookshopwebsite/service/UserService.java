package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface UserService {
    Page<User> getAllUserOrderByCreatedDate(Pageable pageable) ;

    User getUserById(Long userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long userId);

    boolean registerUser(User user);

    void deleteUserById(Long id);

    void saveUser(User user);
    void addBookToUser(Long userId, Long BookId);
    void removeBookFromUser(Long userId, Long BookId) ;

    Long countUser();
}
