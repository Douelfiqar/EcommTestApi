package com.example.ecommapi.mappers.productsMapper;

import com.example.ecommapi.DTOs.productDto.ProductRequest;
import com.example.ecommapi.DTOs.productDto.ProductResponse;
import com.example.ecommapi.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse productToProductResponse(Product product) {

        if(product == null)
            return null;

        ProductResponse productResponse = ProductResponse.builder()
                .category(product.getCategory())
                .name(product.getName())
                .company(product.getCompany())
                .description(product.getDescription())
                .stars(product.getStars())
                .stock(product.getStock())
                .featured(product.isFeatured())
                .price(product.getPrice())
                .reviews(product.getReviews())
                .shipping(product.isShipping())
                .imgUrl(product.getImgURL())
                .colors(product.getColors())
                .id(product.getId()).build();

        return productResponse;
    }

    @Override
    public Product productRequestToProduct(ProductRequest productRequest) {
        if(productRequest == null)
            return null;

        Product product = Product.builder()
                .category(productRequest.category())
                .name(productRequest.name())
                .company(productRequest.company())
                .description(productRequest.description())
                .stars(productRequest.starts())
                .stock(productRequest.stock())
                .featured(productRequest.featured())
                .price(productRequest.price())
                .reviews(productRequest.reviews())
                .shipping(productRequest.shipping())
                .imgURL(productRequest.imgUrl())
                .colors(productRequest.colors())
                .build();

        return product;
    }
}
