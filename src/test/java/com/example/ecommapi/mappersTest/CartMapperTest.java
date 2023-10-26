package com.example.ecommapi.mappersTest;

import com.example.ecommapi.DTOs.cartDto.AddNewCartRequest;
import com.example.ecommapi.DTOs.cartDto.AddOldCartRequest;
import com.example.ecommapi.DTOs.cartDto.CartResponse;
import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.mappers.CartMapper;
import com.example.ecommapi.mappers.CartMapperImpl;
import com.example.ecommapi.repositories.CartProductRepo;
import com.example.ecommapi.services.CartService;
import com.example.ecommapi.services.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CartMapperTest {
    @Mock
    ProductService productService;
    @Mock
    CartService cartService;
    @Mock
    CartProductRepo cartProductRepo;

    CartMapperImpl cartMapperImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
        cartMapperImpl = new CartMapperImpl(productService, cartService, cartProductRepo) {
        };
    }

    @Test
    public void testAddOldCartRequestToCartProduct() {
        UUID cartId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();

        Cart cart = Cart.builder().id(cartId).build();

        ArrayList<String> colorsArray = new ArrayList<>();
        colorsArray.add("Black");
        colorsArray.add("Red");

        Product product = Product.builder()
                .id(productId)
                .reviews(12)
                .name("testName")
                .company("TestCompany")
                .imgURL(new ArrayList<>())
                .price(1000)
                .featured(true)
                .category("categoryTest")
                .stars(5D)
                .stock(12)
                .description("desc")
                .shipping(true)
                .colors(colorsArray).build();

        Mockito.when(cartService.getCart(cartId)).thenReturn(cart);
        Mockito.when(productService.getSingleProduct(productId)).thenReturn(product);

        // Given
        AddOldCartRequest addOldCartRequest = AddOldCartRequest.builder()
                .idCart(cartId)
                .quantity(5)
                .colors(List.of("Black", "Red"))
                .product_id(product.getId())
                .build();

        CartProduct cartProduct = cartMapperImpl.addOldCartRequesttToCartProduct(addOldCartRequest);

        Assertions.assertThat(cartProduct).isNotNull();
        Assertions.assertThat(cartProduct.getQuantity()).isEqualTo(5);
        Assertions.assertThat(cartProduct.getProduct()).isEqualTo(product);
        Assertions.assertThat(cartProduct.getCart()).isEqualTo(cart);
    }


    @Test
    public void testAddNewCartRequestToCartProduct() {
        UUID productId = UUID.randomUUID();


        ArrayList<String> colorsArray = new ArrayList<>();
        colorsArray.add("Black");
        colorsArray.add("Red");

        Product product = Product.builder()
                .id(productId)
                .reviews(12)
                .name("testName")
                .company("TestCompany")
                .imgURL(new ArrayList<>())
                .price(1000)
                .featured(true)
                .category("categoryTest")
                .stars(5D)
                .stock(12)
                .description("desc")
                .shipping(true)
                .colors(colorsArray).build();

        Mockito.when(productService.getSingleProduct(productId)).thenReturn(product);

        // Given
        AddNewCartRequest addNewCartRequest = AddNewCartRequest.builder()
                .quantity(5)
                .colors(List.of("Black", "Red"))
                .id_product(productId)
                .build();

        CartProduct cartProduct = cartMapperImpl.addNewCartRequesttToCartProduct(addNewCartRequest);

        Assertions.assertThat(cartProduct).isNotNull();
        Assertions.assertThat(cartProduct.getQuantity()).isEqualTo(5);
        Assertions.assertThat(cartProduct.getProduct()).isEqualTo(product);
    }

    @Test
    public void testCartProductToCartProductResponse(){

        UUID id_product = UUID.randomUUID();
        UUID id_cart = UUID.randomUUID();

        ArrayList<String> colorsArray = new ArrayList<>();
        colorsArray.add("Black");
        colorsArray.add("Red");
        Product product = Product.builder()
                .id(id_product)
                .reviews(12)
                .name("testName")
                .company("TestCompany")
                .imgURL(new ArrayList<>())
                .price(1000)
                .featured(true)
                .category("categoryTest")
                .stars(5D)
                .stock(12)
                .description("desc")
                .shipping(true)
                .colors(colorsArray).build();

        Cart cart = Cart.builder().id(id_cart).build();

        CartProduct cartProduct = CartProduct.builder()
                .id(id_product)
                .date(new Date())
                .colors(colorsArray)
                .quantity(5)
                .product(product)
                .cart(cart)
                .build();
        Mockito.when(productService.getSingleProduct(id_product)).thenReturn(product);
        CartResponse cartResponse = cartMapperImpl.CartProductToCartResponse(cartProduct);

        Assertions.assertThat(cartResponse).isNotNull();
        Assertions.assertThat(cartResponse.quantity()).isEqualTo(5);
        Assertions.assertThat(cartProduct.getProduct()).isEqualTo(product);
     }
}
