package com.example.produitsservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private Double prix;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}