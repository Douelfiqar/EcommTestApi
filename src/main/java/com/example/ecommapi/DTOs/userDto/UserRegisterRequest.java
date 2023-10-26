package com.example.ecommapi.DTOs.userDto;

public record UserRegisterRequest(String name, String username, String password, String email, String phoneNumber) {
}
