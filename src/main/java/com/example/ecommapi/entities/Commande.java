package com.example.ecommapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private Date date;
    @ManyToOne
    private User user;
    @ManyToMany
    private Collection<Product> productCollection;
    @OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
    private Collection<LigneCommande> ligneCommandeCollection;
}
