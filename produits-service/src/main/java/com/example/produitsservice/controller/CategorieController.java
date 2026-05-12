package com.example.produitsservice.controller;

import com.example.produitsservice.entity.Categorie;
import com.example.produitsservice.service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    @GetMapping
    public List<Categorie> getAll() {
        return categorieService.findAll();
    }

    @GetMapping("/{id}")
    public Categorie getById(@PathVariable Long id) {
        return categorieService.findById(id);
    }
}