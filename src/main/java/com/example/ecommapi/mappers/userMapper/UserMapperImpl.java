package com.example.ecommapi.mappers.userMapper;

import com.example.ecommapi.DTOs.userDto.UserLoginRequest;
import com.example.ecommapi.DTOs.userDto.UserRegisterRequest;
import com.example.ecommapi.DTOs.userDto.UserResponse;
import com.example.ecommapi.entities.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse userToUserResponse(User user) {
        if(user == null)
            return null;

        UserResponse userResponse = UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber()).build();

        return userResponse;
    }
}
