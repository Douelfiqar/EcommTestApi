package com.example.ecommapi.services.serviceImpl;

import com.example.ecommapi.entities.User;
import com.example.ecommapi.models.TypeUser;
import com.example.ecommapi.repositories.UserRepo;
import com.example.ecommapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    @Override
    public User addUser(String username, String password, String email, String phoneNumber, String name){
        Collection<TypeUser> scopes = new ArrayList<>();
        scopes.add(TypeUser.USER);
            return userRepo.save(User.builder().name(name).typeUsers(scopes).username(username).password(password).email(email).phoneNumber(phoneNumber).build());
    }

    public User getUserById(UUID id){
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
