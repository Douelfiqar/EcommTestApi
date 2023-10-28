package com.example.ecommapi.controllers;

import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CartController {

    private CartService cartService;
    @GetMapping("/addCart")
    public Cart addCart(@RequestParam(name = "cart_id") UUID cartId,
                        @RequestParam(name = "id_product") UUID productId,
                        @RequestParam(name = "quantity") int quantity,
                        @RequestParam(name = "color") String color) {
        Cart cart = cartService.addCart(cartId, quantity, color, productId);
        return cart;
    }


    @GetMapping("/getCart/{id}")
    public Cart getCart(@PathVariable UUID user_id){
        Cart cart = cartService.getCart(user_id);
        return cart;
    }
    @GetMapping("/deleteCart/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable UUID cart_id){
        cartService.deleteCart(cart_id);
        return ResponseEntity.ok("Cart with ID " + cart_id + " has been successfully deleted.");
    }

    @GetMapping("/updateCart")
    public ResponseEntity<Cart> cartUpdate(@RequestParam(name = "cartProduct_id")  UUID cartProduct_id,
                                           @RequestParam(name = "quantity") int quantity,
                                           @RequestParam(name = "color") String color){

        Cart cart = cartService.cartUpdate(cartProduct_id, quantity, color);
        return ResponseEntity.ok(cart);
    }
}
