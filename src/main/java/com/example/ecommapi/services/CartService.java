package com.example.ecommapi.services;

import com.example.ecommapi.entities.Cart;

import java.util.UUID;

public interface CartService {
    public Cart getCart(UUID id);

    public Cart addCart(UUID cart_id, int quantity, String color, UUID product_id);

    public Cart cartUpdate(UUID cartProduct_id, int quantity, String color);
    public void deleteCart(UUID cart_id);
}