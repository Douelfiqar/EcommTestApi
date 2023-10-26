package com.example.ecommapi.mappers;

import com.example.ecommapi.DTOs.cartDto.AddNewCartRequest;
import com.example.ecommapi.DTOs.cartDto.AddOldCartRequest;
import com.example.ecommapi.DTOs.cartDto.CartResponse;
import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.repositories.CartProductRepo;
import com.example.ecommapi.repositories.ProductRepo;
import com.example.ecommapi.services.CartService;
import com.example.ecommapi.services.ProductService;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class CartMapperImpl implements  CartMapper{

    private ProductService productService;
    private CartService cartService;
    private CartProductRepo cartProductRepo;
    @Override
    public CartProduct addOldCartRequesttToCartProduct(AddOldCartRequest addOldCartRequest) {
        if(addOldCartRequest == null)
            return null;

        Product product = productService.getSingleProduct(addOldCartRequest.product_id());
        Cart cart = cartService.getCart(addOldCartRequest.idCart());

        CartProduct cartProduct = CartProduct.builder()
                .date(new Date())
                .quantity(addOldCartRequest.quantity())
                .colors(addOldCartRequest.colors())
                .product(product)
                .cart(cart)
                .build();

        cartProduct = cartProductRepo.save(cartProduct);
        return cartProduct;
    }

    @Override
    public CartProduct addNewCartRequesttToCartProduct(AddNewCartRequest addNewCartRequest) {
        if(addNewCartRequest == null)
            return null;

        Product product = productService.getSingleProduct(addNewCartRequest.id_product());

        Cart cart = Cart.builder().build();
        Cart cart1 = cartService.save(cart);
        // Cart cart = cartService.getCart(addNewCartRequest.idCart());

        CartProduct cartProduct = CartProduct.builder()
                .date(new Date())
                .quantity(addNewCartRequest.quantity())
                .colors(addNewCartRequest.colors())
                .product(product)
                .cart(cart1)
                .build();

        cartProductRepo.save(cartProduct);
        return cartProduct;
    }

    @Override
    public CartResponse CartProductToCartResponse(CartProduct cartProduct) {

        Product product = productService.getSingleProduct(cartProduct.getId());

        ProductResponse productResponse = ProductResponse.builder()
                .category(product.getCategory())
                .name(product.getName())
                .company(product.getCompany())
                .description(product.getDescription())
                .stars(product.getStars())
                .stock(product.getStock())
                .featured(product.isFeatured())
                .price(product.getPrice())
                .reviews(product.getReviews())
                .shipping(product.isShipping())
                .imgUrl(product.getImgURL())
                .colors(product.getColors())
                .id(product.getId()).build();

        CartResponse cartResponse = CartResponse.builder()
                .quantity(cartProduct.getQuantity())
                .colors(cartProduct.getColors())
                .productResponse(productResponse).build();

        return cartResponse;
    }
}
