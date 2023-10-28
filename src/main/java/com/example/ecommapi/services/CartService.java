package com.example.ecommapi.services;

import com.example.ecommapi.entities.Cart;
import java.util.UUID;

public interface CartService {
    public Cart getCart(UUID user_id);
    public void deleteCart(UUID cart_id);
}