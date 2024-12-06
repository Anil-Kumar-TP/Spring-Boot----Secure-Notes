package com.notes.secure.notes.service;

import com.notes.secure.notes.dtos.UserDTO;
import com.notes.secure.notes.model.User;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);
}