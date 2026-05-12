package com.example.avisservice.controller;

import com.example.avisservice.entity.Avis;
import com.example.avisservice.service.AvisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
@RequiredArgsConstructor
public class AvisController {

    private final AvisService avisService;

    @GetMapping("/{produitId}")
    public List<Avis> getByProduit(@PathVariable Long produitId) {
        return avisService.findByProduitId(produitId);
    }

    @PostMapping
    public Avis create(@RequestBody Avis avis) {
        return avisService.save(avis);
    }
}