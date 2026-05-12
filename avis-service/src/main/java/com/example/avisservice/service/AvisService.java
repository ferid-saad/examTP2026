package com.example.avisservice.service;

import com.example.avisservice.entity.Avis;
import com.example.avisservice.feign.ProduitClient;
import com.example.avisservice.repository.AvisRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvisService {

    private final AvisRepository avisRepository;
    private final ProduitClient produitClient;

    public List<Avis> findByProduitId(Long produitId) {
        try {
            produitClient.getProduit(produitId);
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Produit introuvable avec l'id : " + produitId
            );
        }
        return avisRepository.findByProduitId(produitId);
    }

    public Avis save(Avis avis) {
        try {
            produitClient.getProduit(avis.getProduitId());
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Produit introuvable avec l'id : " + avis.getProduitId()
            );
        }
        return avisRepository.save(avis);
    }
}