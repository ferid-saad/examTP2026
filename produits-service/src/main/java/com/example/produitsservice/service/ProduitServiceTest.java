package com.example.produitsservice.service;

import com.example.produitsservice.entity.Categorie;
import com.example.produitsservice.entity.Produit;
import com.example.produitsservice.repository.ProduitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProduitServiceTest {

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitService produitService;

    private Produit produit1;
    private Produit produit2;
    private Categorie categorie;

    @BeforeEach
    void setUp() {
        categorie = new Categorie(1L, "Électronique");
        produit1 = new Produit(1L, "Smartphone", 799.99, 50, categorie);
        produit2 = new Produit(2L, "Laptop", 1299.00, 20, categorie);
    }

    // ── Test findAll ──────────────────────────────────────
    @Test
    void findAll_shouldReturnAllProduits() {
        when(produitRepository.findAll())
                .thenReturn(Arrays.asList(produit1, produit2));

        List<Produit> result = produitService.findAll();

        assertEquals(2, result.size());
        assertEquals("Smartphone", result.get(0).getNom());
        verify(produitRepository, times(1)).findAll();
    }

    // ── Test findById OK ──────────────────────────────────
    @Test
    void findById_shouldReturnProduit_whenExists() {
        when(produitRepository.findById(1L))
                .thenReturn(Optional.of(produit1));

        Produit result = produitService.findById(1L);

        assertNotNull(result);
        assertEquals("Smartphone", result.getNom());
        assertEquals(799.99, result.getPrix());
    }

    // ── Test findById 404 ─────────────────────────────────
    @Test
    void findById_shouldThrow404_whenNotExists() {
        when(produitRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class,
                () -> produitService.findById(999L));
    }

    // ── Test findByCategorie ──────────────────────────────
    @Test
    void findByCategorie_shouldReturnProduits() {
        when(produitRepository.findByCategorieId(1L))
                .thenReturn(Arrays.asList(produit1, produit2));

        List<Produit> result = produitService.findByCategorie(1L);

        assertEquals(2, result.size());
        verify(produitRepository, times(1)).findByCategorieId(1L);
    }

    // ── Test save ─────────────────────────────────────────
    @Test
    void save_shouldReturnSavedProduit() {
        when(produitRepository.save(produit1))
                .thenReturn(produit1);

        Produit result = produitService.save(produit1);

        assertNotNull(result);
        assertEquals("Smartphone", result.getNom());
        verify(produitRepository, times(1)).save(produit1);
    }
}