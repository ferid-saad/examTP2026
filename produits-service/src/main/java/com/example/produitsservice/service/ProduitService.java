package com.example.produitsservice.service;

import com.example.produitsservice.entity.Produit;
import com.example.produitsservice.repository.ProduitRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Cacheable("produits")
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Cacheable(value = "produits", key = "#id")
    public Produit findById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec id: " + id));
    }

    @CacheEvict(value = "produits", allEntries = true)
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @CacheEvict(value = "produits", allEntries = true)
    public Produit update(Long id, Produit produitDetails) {
        Produit produit = findById(id);
        produit.setNom(produitDetails.getNom());
        produit.setPrix(produitDetails.getPrix());
        produit.setQuantite(produitDetails.getQuantite());
        produit.setCategorie(produitDetails.getCategorie());
        return produitRepository.save(produit);
    }

    @CacheEvict(value = "produits", allEntries = true)
    public void deleteById(Long id) {
        produitRepository.deleteById(id);
    }
}