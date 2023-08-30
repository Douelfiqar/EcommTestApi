package com.example.ecommapi.services;

import com.example.ecommapi.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = accountService.findUserByUsername(username);
        if(user == null) throw new UsernameNotFoundException(String.format("User %s not found", username));
        String []roles = user.getAppRoleCollection().stream().map( u -> u.getRole()).toArray(String[]::new);
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                                  .withUsername(user.getUsername())
                                  .password(user.getPassword())
                                  .roles(roles).build();
        return userDetails;
    }
}
