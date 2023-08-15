package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.entity.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(Long roleId);
    List<Role> getAllRoles();
    void deleteRole(Long roleId);
}
