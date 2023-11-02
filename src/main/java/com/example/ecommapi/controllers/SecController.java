package com.example.ecommapi.controllers;

import com.example.ecommapi.DTOs.userDto.UserLoginRequest;
import com.example.ecommapi.DTOs.userDto.UserRegisterRequest;
import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.User;
import com.example.ecommapi.services.CartService;
import com.example.ecommapi.services.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SecController {

    private AuthenticationManager authenticationManager;
    private JwtEncoder jwtEncoder;
    private UserServiceImpl userService;
    private PasswordEncoder passwordEncoder;
    private CartService cartService;
    @PostMapping("/login")
    public Map<String, String> login(UserLoginRequest userLoginRequest){
        System.out.println("login");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest.username(), userLoginRequest.password()));
        System.out.println(authentication);
        Instant instant = Instant.now();
        String scope = authentication.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(instant.plus(10, ChronoUnit.MINUTES))
                .subject(userLoginRequest.username())
                .claim("scope", scope)
                .build();

        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS512).build(),
                jwtClaimsSet
        );
        String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
        return Map.of("accessToken", jwt);
    }

    @PostMapping("/signup")
    public Map<String, String> signup(UserRegisterRequest userRegisterRequest){

        User user = userService.addUser(userRegisterRequest.username(), passwordEncoder.encode(userRegisterRequest.password()), userRegisterRequest.email(), userRegisterRequest.phoneNumber(),userRegisterRequest.name());
        User user1 = userService.getUserByUsername(userRegisterRequest.username());
        Cart cart = cartService.createCartForUser(user1.getId());

        if(!(user == null)) {
            Instant instant = Instant.now();

            JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                    .issuedAt(instant.plus(10, ChronoUnit.MINUTES))
                    .subject(userRegisterRequest.username())
                    .claim("scope", "user")
                    .build();

            JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                    JwsHeader.with(MacAlgorithm.HS512).build(),
                    jwtClaimsSet
            );
            String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
            return Map.of("accessToken", jwt);
        }
        return Map.of("accessToken", null);
    }
}
