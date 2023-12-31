package com.example.ecommapi.services.serviceImpl;

import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.User;
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
    public Cart createCartForUser(UUID user_id){
        User user = userRepo.findById(user_id).orElseThrow();
        Cart cart = Cart.builder().user(user).build();
        cart = cartRepo.save(cart);
        return cart;
    }
    @Override
    public Cart getCart(UUID cart_id) {
        Cart cart = cartRepo.findById(cart_id).orElseThrow();
        return cart;
    }

    @Override
    public void deleteCart(UUID cart_id) {
        cartRepo.deleteById(cart_id);
    }
}
