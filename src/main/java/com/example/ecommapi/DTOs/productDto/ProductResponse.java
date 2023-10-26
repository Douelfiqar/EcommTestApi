package com.example.ecommapi.DTOs.productDto;

import lombok.Builder;

import java.util.Collection;
import java.util.UUID;
@Builder
public record ProductResponse(UUID id, String name, int stock, double price, boolean shipping, String category, Collection<String> imgUrl, Collection<String> colors,Integer reviews, Double stars, String description, boolean featured, String company) {
}
