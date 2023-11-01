package com.example.ecommapi.services;

import com.example.ecommapi.entities.User;

import java.util.UUID;

public interface UserService {
    public User addUser(String username, String password, String email, String phoneNumber, String name);
    public User getUserById(UUID id);
    public User getUserByUsername(String username);
}
