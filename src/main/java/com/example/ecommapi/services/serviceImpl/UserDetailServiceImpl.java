package com.example.ecommapi.services.serviceImpl;

import com.example.ecommapi.entities.User;
import com.example.ecommapi.models.TypeUser;
import com.example.ecommapi.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = accountService.findUserByUsername(username);
        if(user == null) throw new UsernameNotFoundException(String.format("User %s not found", username));

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                                  .withUsername(user.getUsername())
                                  .password(user.getPassword())
                                  .roles(user.getTypeUsers().toString()).build();
        return userDetails;
    }
}