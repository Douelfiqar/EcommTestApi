package com.example.ecommapi.repositories;

import com.example.ecommapi.entities.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CartProductRepo extends JpaRepository<CartProduct, UUID> {
}
