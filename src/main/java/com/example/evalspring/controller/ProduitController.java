package com.example.evalspring.controller;

import com.example.evalspring.model.Produit;
import com.example.evalspring.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Integer id) {
        Produit produit = produitService.recupererProduitParId(id);
        return ResponseEntity.ok(produit);
    }

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.recupererTousLesProduits();
        return ResponseEntity.ok(produits);
    }

    @PostMapping
    public ResponseEntity<Produit> ajouterProduit(@Valid @RequestBody Produit produit) {
        Produit nouveauProduit = produitService.ajouterProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauProduit);
    }
}

