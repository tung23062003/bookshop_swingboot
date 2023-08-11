package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.entity.Role;
import com.group7.bookshopwebsite.entity.User;

import java.util.List;
import java.util.Set;

public interface UserRoleService {
    void assignRoleToUser(Long userId, Long roleId);
    void unassignRoleFromUser(Long userId, Long roleId);
    Set<Role> getUserRoles(Long userId);
    Set<User> getUsersByRole(Long roleId);
}
