package com.example.ecommapi.mappers.cartMapper;

import com.example.ecommapi.DTOs.cartDto.AddNewCartRequest;
import com.example.ecommapi.DTOs.cartDto.AddOldCartRequest;
import com.example.ecommapi.DTOs.cartDto.CartResponse;
import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.mappers.productsMapper.ProductMapperImpl;
import com.example.ecommapi.repositories.CartProductRepo;
import com.example.ecommapi.services.CartService;
import com.example.ecommapi.services.serviceImpl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@AllArgsConstructor
public class CartMapperImpl {


}
