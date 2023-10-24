package com.example.ecommapi.services;

import com.example.ecommapi.entities.User;
import com.example.ecommapi.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;

    public User addUser(String username, String password, String email, String phoneNumber, String name){
            return userRepo.save(User.builder().name(name).username(username).password(password).email(email).phoneNumber(phoneNumber).build());
    }
}
