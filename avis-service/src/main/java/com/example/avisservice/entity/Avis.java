package com.example.avisservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "avis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produitId;

    private String auteur;

    private String commentaire;

    @Min(1)
    @Max(5)
    private int note;
}