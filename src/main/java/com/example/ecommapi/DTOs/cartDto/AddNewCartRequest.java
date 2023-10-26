package com.example.ecommapi.DTOs.cartDto;

import lombok.Builder;

import java.util.Collection;
import java.util.UUID;

//We have to create a new Cart so in this case we don't need te send id by request
@Builder
public record AddNewCartRequest(int quantity, Collection<String> colors, UUID id_product) {
}
