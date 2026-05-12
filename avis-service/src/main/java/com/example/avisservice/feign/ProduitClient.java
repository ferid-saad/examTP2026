package com.example.avisservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produits-service")
public interface ProduitClient {

    @GetMapping("/api/produits/{id}")
    Object getProduit(@PathVariable("id") Long id);
}
