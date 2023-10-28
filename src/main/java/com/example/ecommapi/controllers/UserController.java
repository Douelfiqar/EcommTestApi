package com.example.ecommapi.controllers;

import com.example.ecommapi.services.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;


}
