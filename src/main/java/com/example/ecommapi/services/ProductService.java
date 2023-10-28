package com.example.ecommapi.services;

import com.example.ecommapi.entities.Product;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<Product> getProducts(Integer pageNo, Integer pageSize);
    public Product getSingleProduct(UUID id);
    public Collection<Product> findAllFeaturedProducts();
}
