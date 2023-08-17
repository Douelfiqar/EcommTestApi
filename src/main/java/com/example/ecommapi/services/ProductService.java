package com.example.ecommapi.services;

import com.example.ecommapi.entities.Product;
import com.example.ecommapi.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepo productRepo;
    public Collection<Product> getProducts(){
        return productRepo.findAll();
    }
    public Product getSingleProduct(UUID id){
        Optional<Product> optionalProduct = productRepo.findById(id);
        return optionalProduct.orElse(null); // Return null if not found, or handle it differently

    }
}
