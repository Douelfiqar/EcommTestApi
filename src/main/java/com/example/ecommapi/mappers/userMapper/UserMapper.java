package com.example.ecommapi.mappers.userMapper;

import com.example.ecommapi.DTOs.userDto.UserLoginRequest;
import com.example.ecommapi.DTOs.userDto.UserRegisterRequest;
import com.example.ecommapi.DTOs.userDto.UserResponse;
import com.example.ecommapi.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserResponse userToUserResponse(User user);
}
