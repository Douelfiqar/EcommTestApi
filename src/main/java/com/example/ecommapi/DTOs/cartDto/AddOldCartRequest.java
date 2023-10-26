package com.example.ecommapi.DTOs.cartDto;

import lombok.Builder;

import java.util.Collection;
import java.util.UUID;

@Builder
public record AddOldCartRequest(UUID idCart, int quantity, Collection<String> colors, UUID product_id) {
}
