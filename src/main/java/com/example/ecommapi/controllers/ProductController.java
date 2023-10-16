package com.example.ecommapi.controllers;

import com.example.ecommapi.entities.Product;
import com.example.ecommapi.repositories.ProductRepo;
import com.example.ecommapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private ProductRepo productRepo;

    @GetMapping(value = "/getAllProducts", produces = "application/json")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(defaultValue = "0") Integer pageCurrent,
                                                     @RequestParam(defaultValue = "9") Integer pageSize) {
        List<Product> products = productService.getProducts(pageCurrent, pageSize);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/getCountProduct")
    public ResponseEntity<Integer> getCountProduct() {
        Long totalProduct = productRepo.count();
        Integer totalPages = (int) Math.round(totalProduct / 10);
        return ResponseEntity.ok(totalPages);
    }

    @GetMapping("/getSingleProduct/{id}")
    public Product getSingleProduct(@PathVariable UUID id){
        Product product = productService.getSingleProduct(id);
        return product;
    }

    @GetMapping("/Checkout")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void checkoutTest(){
        System.out.println("access");
    }
    @GetMapping("/featuredProducts")
    public Collection<Product> findAllFeaturedProducts(){
        Collection<Product> productCollection = new ArrayList<>();
        productCollection = productService.findAllFeaturedProducts();
        return productCollection;
    }

}
