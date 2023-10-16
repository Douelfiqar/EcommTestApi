package com.example.ecommapi.repositories;

import com.example.ecommapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.UUID;


@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {
    @Query("SELECT p FROM Product p WHERE p.featured = true")
    Collection<Product> findAllFeaturedProducts();

}
