package com.example.produitsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    // Constructeur vide obligatoire pour JPA
    public Categorie() {}

    // Constructeur avec arguments
    public Categorie(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters
    public Long getId() { return id; }
    public String getNom() { return nom; }

    // Setters (optionnels mais utiles)
    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
}
