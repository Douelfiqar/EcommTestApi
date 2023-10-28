package com.example.ecommapi.DTOs.userDto;

import lombok.Builder;

@Builder
public record UserResponse(String username, String name, String email, String phoneNumber) {
}
