package com.example.ecommapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToMany
    private List<CartProduct> cartProductList;
}
