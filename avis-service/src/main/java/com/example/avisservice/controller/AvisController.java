package com.example.avisservice.controller;

import com.example.avisservice.entity.Avis;
import com.example.avisservice.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
public class AvisController {

    private final AvisService avisService;

    @Autowired
    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    @GetMapping("/{produitId}")
    public List<Avis> getByProduit(@PathVariable Long produitId) {
        return avisService.findByProduitId(produitId);
    }

    @PostMapping
    public Avis create(@RequestBody Avis avis) {
        return avisService.save(avis);
    }

    @GetMapping
    public List<Avis> getAll() {
        return avisService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avisService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Avis update(@PathVariable Long id, @RequestBody Avis avis) {
        avis.setId(id);
        return avisService.update(avis);
    }
}
