package com.example.ecommapi.services.serviceImpl;

import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.repositories.CartProductRepo;
import com.example.ecommapi.services.CartProductService;
import com.example.ecommapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartProductServiceImpl implements CartProductService {

    private CartServiceImpl cartService;
    private ProductService productService;
    private CartProductRepo cartProductRepo;

    @Override
    public CartProduct addNewProductCart(UUID cart_id, int quantity, String color, UUID product_id) {
        Collection<String> colors = new ArrayList<>();
        colors.add(color);
        Product product = productService.getSingleProduct(product_id);
        Cart cart = cartService.getCart(cart_id);
        CartProduct cartProduct = CartProduct.builder().colors(colors)
                .product(product)
                .cart(cart)
                .quantity(quantity)
                .date(new Date()).build();

        return cartProductRepo.save(cartProduct);
    }

    @Override
    public CartProduct updateOldCartProduct(UUID cartProduct_id, int quantity, String color){

        CartProduct cartProduct = cartProductRepo.findById(cartProduct_id).orElseThrow();
        Collection<String> updatedColors = new ArrayList<>(cartProduct.getColors());

        int newQantity = cartProduct.getQuantity() + quantity;
        CartProduct cartProduct1 = CartProduct.builder()
                .product(cartProduct.getProduct())
                .quantity(newQantity)
                .colors(updatedColors)
                .cart(cartProduct.getCart()).build();
        return cartProduct1;
    }


}
