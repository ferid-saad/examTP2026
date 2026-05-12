package com.example.produitsservice.service;

import com.example.produitsservice.entity.Produit;
import com.example.produitsservice.entity.Categorie;
import com.example.produitsservice.repository.ProduitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProduitServiceTest {

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitService produitService;

    private Produit produit;

    @BeforeEach
    void setUp() {
        Categorie categorie = new Categorie(1L, "Informatique");
        produit = new Produit(1L, "PC Portable", 1200.0, 10, categorie);
    }

    @Test
    void testFindById() {
        when(produitRepository.findById(1L)).thenReturn(Optional.of(produit));

        Produit result = produitService.findById(1L);

        assertNotNull(result);
        assertEquals("PC Portable", result.getNom());
        verify(produitRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        when(produitRepository.findAll()).thenReturn(Arrays.asList(produit));

        var result = produitService.findAll();

        assertEquals(1, result.size());
        verify(produitRepository, times(1)).findAll();
    }
}
