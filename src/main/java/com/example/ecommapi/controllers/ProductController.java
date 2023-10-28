package com.example.ecommapi.controllers;

import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.mappers.productsMapper.ProductMapperImpl;
import com.example.ecommapi.repositories.ProductRepo;
import com.example.ecommapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private ProductRepo productRepo;
    private ProductMapperImpl productMapper;

    @GetMapping(value = "/getAllProducts", produces = "application/json")
    public ResponseEntity<List<ProductResponse>> getProducts(@RequestParam(defaultValue = "0") Integer pageCurrent,
                                                             @RequestParam(defaultValue = "9") Integer pageSize) {
        List<Product> products = productService.getProducts(pageCurrent, pageSize);
        List<ProductResponse> productResponseList = products.stream().map(p -> productMapper.productToProductResponse(p)).collect(Collectors.toList());

        return ResponseEntity.ok(productResponseList);
    }
    //pagination
    @GetMapping("/getCountProduct")
    public ResponseEntity<Integer> getCountProduct() {
        Long totalProduct = productRepo.count();
        Integer totalPages = (int) Math.round(totalProduct / 10);
        return ResponseEntity.ok(totalPages);
    }

    @GetMapping("/getSingleProduct/{id}")
    public ResponseEntity<ProductResponse> getSingleProduct(@PathVariable UUID id){
        Product product = productService.getSingleProduct(id);
        ProductResponse productResponse = productMapper.productToProductResponse(product);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/Checkout")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void checkoutTest(){
        System.out.println("access");
    }
    @GetMapping("/featuredProducts")
    public ResponseEntity<List<ProductResponse>> findAllFeaturedProducts(){
        Collection<Product> productCollection = new ArrayList<>();
        productCollection = productService.findAllFeaturedProducts();
        List<ProductResponse> productResponseList = productCollection.stream().map(p -> productMapper.productToProductResponse(p)).collect(Collectors.toList());
        return ResponseEntity.ok(productResponseList);
    }

}
