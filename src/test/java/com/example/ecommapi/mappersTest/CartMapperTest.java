package com.example.ecommapi.mappersTest;

import com.example.ecommapi.DTOs.cartDto.AddNewCartRequest;
import com.example.ecommapi.DTOs.cartDto.AddOldCartRequest;
import com.example.ecommapi.DTOs.cartDto.CartResponse;
import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.mappers.cartMapper.CartMapperImpl;
import com.example.ecommapi.mappers.productsMapper.ProductMapperImpl;
import com.example.ecommapi.repositories.CartProductRepo;
import com.example.ecommapi.services.CartService;
import com.example.ecommapi.services.serviceImpl.ProductServiceImpl;
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
    ProductServiceImpl productService;
    @Mock
    CartService cartService;
    @Mock
    CartProductRepo cartProductRepo;
    @Mock
    ProductMapperImpl productMapper;
    CartMapperImpl cartMapperImpl;



}
