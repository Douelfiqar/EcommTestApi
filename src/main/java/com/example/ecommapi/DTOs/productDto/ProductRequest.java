package com.example.ecommapi.DTOs.productDto;

import java.util.Collection;

public record ProductRequest(String name, int stock, double price, boolean shipping, String category, Collection<String> imgUrl, String description, String company) {
}
