package com.example.ecommapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String name;
    @Column(unique = true)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Commande> commandesList;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoleCollection;
    @OneToOne
    private Cart cart;
}
