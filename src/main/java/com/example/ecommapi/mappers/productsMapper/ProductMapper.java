package com.example.ecommapi.mappers.productsMapper;

import com.example.ecommapi.DTOs.productDto.ProductRequest;
import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductResponse productToProductResponse(Product product);
    Product productRequestToProduct(ProductRequest productRequest);
}
