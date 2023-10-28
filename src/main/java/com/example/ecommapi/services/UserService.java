package com.example.ecommapi.services;

import com.example.ecommapi.entities.User;

public interface UserService {
    public User addUser(String username, String password, String email, String phoneNumber, String name);
}
