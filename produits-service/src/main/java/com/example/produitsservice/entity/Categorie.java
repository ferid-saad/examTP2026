package com.example.produitsservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
}