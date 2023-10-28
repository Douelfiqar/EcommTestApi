package com.example.ecommapi.services;

import com.example.ecommapi.DTOs.productDto.ProductRequest;
import com.example.ecommapi.entities.CartProduct;

import java.util.Collection;
import java.util.UUID;

public interface CartProductService {
    public CartProduct addNewCartProduct(UUID cart_id, int quantity, String color, UUID product_id);
    public CartProduct updateOldCartProduct(UUID cartProduct_id, int quantity, String color);
}
