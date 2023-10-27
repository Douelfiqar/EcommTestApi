package com.example.ecommapi.mappersTest;

import com.example.ecommapi.DTOs.productDto.ProductRequest;
import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Product;
import com.example.ecommapi.mappers.productsMapper.ProductMapperImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.UUID;

public class ProductMapperTest {

    ProductMapperImpl productMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
        productMapper = new ProductMapperImpl();
    }

    @Test
    public void testProductRequestToProduct(){

        ArrayList<String> colorsArray = new ArrayList<>();
        colorsArray.add("Black");
        colorsArray.add("Red");

        ProductRequest productRequest = ProductRequest.builder()
                .reviews(12)
                .name("testName")
                .company("TestCompany")
                .imgUrl(colorsArray)
                .price(1000)
                .featured(true)
                .category("categoryTest")
                .starts(5D)
                .stock(12)
                .reviews(122)
                .description("desc")
                .shipping(true)
                .colors(colorsArray)
                .build();

        Product product = productMapper.productRequestToProduct(productRequest);

        Assertions.assertThat(product).isNotNull();
        Assertions.assertThat(product).isEqualTo(product);
    }
    @Test
    public void testProductToProductResponse(){
        UUID productId = UUID.randomUUID();

        ArrayList<String> colorsArray = new ArrayList<>();
        colorsArray.add("Black");
        colorsArray.add("Red");

        Product product = Product.builder()
                .id(productId)
                .reviews(12)
                .name("testName")
                .company("TestCompany")
                .imgURL(new ArrayList<>())
                .price(1000)
                .featured(true)
                .category("categoryTest")
                .stars(5D)
                .stock(12)
                .description("desc")
                .shipping(true)
                .colors(colorsArray).build();

        ProductResponse productResponse = productMapper.productToProductResponse(product);

        Assertions.assertThat(product).isNotNull();
        Assertions.assertThat(productResponse).isEqualTo(productResponse);
    }

}
