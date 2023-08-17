package com.example.ecommapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     private String name;
     private int stock;
     private double price;
     private boolean shipping;
     @ElementCollection(fetch = FetchType.EAGER)  // Specified fetch type
     @CollectionTable(name = "colors", joinColumns = @JoinColumn(name = "product_id"))
     private Collection<String> colors = new ArrayList<>();
     private String category;
     @ElementCollection(fetch = FetchType.EAGER)  // Specified fetch type
     @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
     private Collection<String> imgURL = new ArrayList<>();
     private int reviews;
     private double stars;
     @Column(length = 2000)
     private String description;
     private String company;
     @OneToMany(mappedBy = "product")
     private Collection<LigneCommande> ligneCommandeCollection;
    
}
