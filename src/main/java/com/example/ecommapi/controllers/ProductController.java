package com.example.ecommapi.controllers;

import com.example.ecommapi.entities.Product;
import com.example.ecommapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/getAllProducts")
    public Collection<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/getSingleProduct/{id}")
    public Product getSingleProduct(@PathVariable UUID id){
        return productService.getSingleProduct(id);
    }

    @PostMapping("/insertProduct")
    public Product insertProduct(@RequestBody Product product){
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setCategory(product.getName());
        product1.setCompany(product.getCompany());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setReviews(product.getReviews());
        product1.setStars(product.getStars());
        product1.setStock(product.getStock());
        product1.setShipping(true);
        product1.setColors(product.getColors());
        product1.setImgURL(product.getImgURL());

        return product1;
    }
}
