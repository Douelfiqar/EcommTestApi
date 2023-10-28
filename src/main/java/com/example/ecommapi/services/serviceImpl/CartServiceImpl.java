package com.example.ecommapi.services.serviceImpl;

import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.repositories.CartRepo;
import com.example.ecommapi.repositories.UserRepo;
import com.example.ecommapi.services.CartProductService;
import com.example.ecommapi.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private CartRepo cartRepo;
    private UserRepo userRepo;
    @Override
    public Cart getCart(UUID user_id) {
        Cart cart = userRepo.findCartByUserId(user_id);
        return cart;
    }

    @Override
    public void deleteCart(UUID cart_id) {
        cartRepo.deleteById(cart_id);
    }
}