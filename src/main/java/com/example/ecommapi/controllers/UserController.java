package com.example.ecommapi.controllers;

import com.example.ecommapi.entities.Product;
import com.example.ecommapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;


}
