package com.example.ecommapi.DTOs.userDto;

public record UserRegisterRequest(String username, String password, String name,  String email, String phoneNumber) {
}
