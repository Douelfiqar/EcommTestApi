package com.example.ecommapi.mappersTest;

import com.example.ecommapi.DTOs.userDto.UserResponse;
import com.example.ecommapi.entities.User;
import com.example.ecommapi.mappers.userMapper.UserMapperImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class UserMapperTest {

    UserMapperImpl userMapper;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        userMapper = new UserMapperImpl();
    }
    @Test
    public void testUserToUserResponse(){

        User user = User.builder()
                .name("Idriss")
                .username("Rebel")
                .phoneNumber("068521312")
                .email("douidriss@gmail.com")
                .password("123456")
                .build();

        UserResponse userResponse = userMapper.userToUserResponse(user);

        Assertions.assertThat(userResponse).isNotNull();
        Assertions.assertThat(userResponse.name()).isEqualTo("Idriss");
        Assertions.assertThat(userResponse.username()).isEqualTo("Rebel");
        Assertions.assertThat(userResponse.phoneNumber()).isEqualTo("068521312");
        Assertions.assertThat(userResponse.email()).isEqualTo("douidriss@gmail.com");


    }
}
