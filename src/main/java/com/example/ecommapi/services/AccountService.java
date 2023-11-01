package com.example.ecommapi.services;

import com.example.ecommapi.entities.User;

public interface AccountService {
    User addNewUser(String name, String username, String Password, String confirmPassword, String email, String phoneNumber);
    //void addUserRole(String username, String role);
    //void removeRoleFromUser(String username, String role);
    User findUserByUsername(String username);
}
