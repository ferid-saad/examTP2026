package com.example.produitsservice.service;

import com.example.produitsservice.entity.Categorie;
import com.example.produitsservice.repository.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public Categorie findById(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Catégorie introuvable avec l'id : " + id
                ));
    }

    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }
}