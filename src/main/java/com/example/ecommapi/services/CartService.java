package com.example.ecommapi.services;

import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.repositories.CartRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepo cartRepo;

    public Cart save(Cart cart){
        return cartRepo.save(cart);
    }
    public Cart getCart(UUID id){
        Cart cart = cartRepo.findById(id).orElseThrow();
        return cart;
    }
}
