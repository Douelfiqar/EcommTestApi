package com.example.ecommapi.services;

import com.example.ecommapi.entities.Product;
import com.example.ecommapi.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepo productRepo;
    public List<Product> getProducts(Integer pageNo, Integer pageSize){

        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<Product> pagedResult = productRepo.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
    public Product getSingleProduct(UUID id){
        Product product = productRepo.findById(id).orElse(null);
        return product; // Return null if not found, or handle it differently
    }

    public Collection<Product> findAllFeaturedProducts(){
        return productRepo.findAllFeaturedProducts();
    }
}
