package com.example.produitsservice.controller;

import com.example.produitsservice.entity.Produit;
import com.example.produitsservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @GetMapping
    public List<Produit> getAll(
            @RequestParam(required = false) Long categorieId) {
        if (categorieId != null) {
            return produitService.findByCategorie(categorieId);
        }
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    public Produit getById(@PathVariable Long id) {
        return produitService.findById(id);
    }

    @PostMapping
    public Produit create(@RequestBody Produit produit) {
        return produitService.save(produit);
    }
}