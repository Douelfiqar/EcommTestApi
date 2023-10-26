package com.example.ecommapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CartProduct {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date date;
    private int quantity;
    @ElementCollection(fetch = FetchType.EAGER)  // Specified fetch type
    @CollectionTable(name = "colors_selcted_cart", joinColumns = @JoinColumn(name = "cart_id"))
    private Collection<String> colors = new ArrayList<>();
    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;
}
