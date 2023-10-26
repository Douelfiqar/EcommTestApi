package com.example.ecommapi.mappers;

import com.example.ecommapi.DTOs.cartDto.AddNewCartRequest;
import com.example.ecommapi.DTOs.cartDto.AddOldCartRequest;
import com.example.ecommapi.DTOs.cartDto.CartResponse;
import com.example.ecommapi.entities.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
//    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartProduct addOldCartRequesttToCartProduct(AddOldCartRequest addOldCartRequest);
    CartProduct addNewCartRequesttToCartProduct(AddNewCartRequest addNewCartRequest);
    CartResponse CartProductToCartResponse(CartProduct cartProduct);
}

