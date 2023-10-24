package com.example.ecommapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
     @NotBlank
     private String name;
     @Size(min = 0, message = "The stock cannot be < 0")
     private int stock;
     @Size(min = 0, message = "The price cannot be < 0")
     @NotNull
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
     @Column(name = "featured", columnDefinition = "boolean default false")
     private boolean featured;
     private String company;
     @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     private Collection<LigneCommande> ligneCommandeCollection;
    
}
