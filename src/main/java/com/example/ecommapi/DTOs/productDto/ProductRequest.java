package com.example.ecommapi.DTOs.productDto;

import lombok.Builder;

import java.util.Collection;


@Builder
public record ProductRequest(String name, int stock, double price, boolean shipping, double starts, int reviews, String category, Collection<String> imgUrl, boolean featured, Collection<String> colors, String description, String company) {
}
