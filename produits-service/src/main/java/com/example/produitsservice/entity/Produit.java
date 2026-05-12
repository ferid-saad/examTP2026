package com.example.produitsservice.entity;

import com.example.produitsservice.entity.Categorie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Produit {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private double prix;
    private int quantite;

    @ManyToOne
    private Categorie categorie;

    // Constructeur vide obligatoire pour JPA
    public Produit() {}

    // Constructeur avec arguments
    public Produit(Long id, String nom, double prix, int quantite, Categorie categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
    }

    // Getters et setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public int getQuantite() { return quantite; }
    public Categorie getCategorie() { return categorie; }
}
