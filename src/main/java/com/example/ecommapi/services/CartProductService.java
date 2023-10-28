package com.example.ecommapi.services;

import com.example.ecommapi.entities.CartProduct;
import java.util.UUID;

public interface CartProductService {
    public CartProduct updateOldCartProduct(UUID cartProduct_id, int quantity, String color);
    public CartProduct addNewProductCart(UUID cart_id, int quantity, String color, UUID product_id);
}
