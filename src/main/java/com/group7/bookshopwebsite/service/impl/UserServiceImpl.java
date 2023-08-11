package com.group7.bookshopwebsite.service.impl;

import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.entity.User;
import com.group7.bookshopwebsite.repository.UserRepository;
import com.group7.bookshopwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;

        @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<Book> getFavoriteBooks(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // Xử lý khi không tìm thấy user với ID tương ứng
            return null;
        }
        return user.getFavoriteBooks();
    }
}
