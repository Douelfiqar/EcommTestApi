package com.example.ecommapi.DTOs.cartDto;

import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Builder
public record CartResponse(UUID id, int quantity, Collection<String> colors, ProductResponse productResponse) {
}
