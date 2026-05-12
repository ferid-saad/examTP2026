package com.example.produitsservice.repository;

import com.example.produitsservice.entity.Produit;
import com.example.produitsservice.entity.Categorie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProduitRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProduitRepository produitRepository;

    private Categorie categorie;

    @BeforeEach
    void setUp() {
        categorie = new Categorie(null, "Informatique");
        entityManager.persist(categorie);
    }

    @Test
    void testSaveProduit() {
        Produit produit = new Produit(null, "PC Portable", 1200.0, 10, categorie);
        Produit saved = produitRepository.save(produit);

        assertNotNull(saved.getId());
        assertEquals("PC Portable", saved.getNom());
        assertEquals(1200.0, saved.getPrix());
    }
}
