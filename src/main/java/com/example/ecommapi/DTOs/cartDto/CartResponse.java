package com.example.ecommapi.DTOs.cartDto;

import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.CartProduct;
import com.example.ecommapi.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
public record CartResponse(UUID id, List<CartProduct> cartProductList) {
}
