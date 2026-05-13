package com.example.produitsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    public Categorie() {}

    public Categorie(String nom) {
        this.nom = nom;
    }

    public Categorie(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }

    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
}