package com.example.ecommapi.services.serviceImpl;

import com.example.ecommapi.DTOs.cartDto.AddNewCartRequest;
import com.example.ecommapi.DTOs.cartDto.AddOldCartRequest;
import com.example.ecommapi.DTOs.cartDto.CartResponse;
import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.mappers.cartMapper.CartMapper;
import com.example.ecommapi.mappers.cartMapper.CartMapperImpl;
import com.example.ecommapi.repositories.CartRepo;
import com.example.ecommapi.repositories.ProductRepo;
import com.example.ecommapi.services.CartProductService;
import com.example.ecommapi.services.CartService;
import com.example.ecommapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private CartRepo cartRepo;
    private CartProductService cartProductService;
    private ProductServiceImpl productService;
    @Override
    public Cart getCart(UUID id) {
        Cart cart = cartRepo.findById(id).orElseThrow();
        return cart;
    }

    @Override
    public Cart addCart(UUID cart_id, int quantity, String color, UUID product_id) {
        cartProductService.addNewCartProduct(cart_id, quantity, color, product_id);
        Cart cart = cartRepo.findById(cart_id).orElseThrow();
        return cart;
    }

    @Override
    public void deleteCart(UUID cart_id) {
        cartRepo.deleteById(cart_id);
    }

    @Override
    public Cart cartUpdate(UUID cartProduct_id, int quantity, String color) {
        CartProduct cartProduct = cartProductService.updateOldCartProduct(cartProduct_id, quantity, color);
        return cartRepo.findById(cartProduct.getId()).orElseThrow();
    }
}
