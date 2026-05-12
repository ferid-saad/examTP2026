package com.example.avisservice.service;

import com.example.avisservice.entity.Avis;
import com.example.avisservice.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService {

    private final AvisRepository avisRepository;

    @Autowired
    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    public List<Avis> findAll() {
        return avisRepository.findAll();
    }

    public List<Avis> findByProduitId(Long produitId) {
        return avisRepository.findByProduitId(produitId);
    }

    public Avis save(Avis avis) {
        return avisRepository.save(avis);
    }

    public Avis update(Avis avis) {
        return avisRepository.save(avis);
    }

    public void deleteById(Long id) {
        avisRepository.deleteById(id);
    }
}
