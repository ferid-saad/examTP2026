package com.example.produitsservice.repository;

import com.example.produitsservice.entity.Categorie;
import com.example.produitsservice.entity.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProduitRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    private Categorie categorie;

    @BeforeEach
    void setUp() {
        categorie = entityManager.persistAndFlush(
                new Categorie(null, "Électronique")
        );
    }

    // ── Test save et findById ─────────────────────────────
    @Test
    void save_andFindById_shouldWork() {
        Produit produit = new Produit(null, "Smartphone", 799.99, 50, categorie);
        Produit saved = produitRepository.save(produit);

        Optional<Produit> found = produitRepository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("Smartphone", found.get().getNom());
        assertEquals(799.99, found.get().getPrix());
    }

    // ── Test findByCategorieId ────────────────────────────
    @Test
    void findByCategorieId_shouldReturnProduits() {
        entityManager.persistAndFlush(
                new Produit(null, "Smartphone", 799.99, 50, categorie)
        );
        entityManager.persistAndFlush(
                new Produit(null, "Laptop", 1299.00, 20, categorie)
        );

        List<Produit> produits = produitRepository.findByCategorieId(categorie.getId());

        assertEquals(2, produits.size());
    }

    // ── Test findAll ──────────────────────────────────────
    @Test
    void findAll_shouldReturnAllProduits() {
        entityManager.persistAndFlush(
                new Produit(null, "Smartphone", 799.99, 50, categorie)
        );
        entityManager.persistAndFlush(
                new Produit(null, "Laptop", 1299.00, 20, categorie)
        );

        List<Produit> produits = produitRepository.findAll();

        assertEquals(2, produits.size());
    }

    // ── Test delete ───────────────────────────────────────
    @Test
    void delete_shouldRemoveProduit() {
        Produit produit = entityManager.persistAndFlush(
                new Produit(null, "Smartphone", 799.99, 50, categorie)
        );

        produitRepository.deleteById(produit.getId());

        Optional<Produit> found = produitRepository.findById(produit.getId());
        assertFalse(found.isPresent());
    }
}