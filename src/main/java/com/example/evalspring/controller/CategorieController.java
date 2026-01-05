package com.example.evalspring.controller;

import com.example.evalspring.model.Categorie;
import com.example.evalspring.service.CategorieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id) {
        Categorie categorie = categorieService.recupererCategorieParId(id);
        return ResponseEntity.ok(categorie);
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categorieService.recupererToutesLesCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Categorie> ajouterCategorie(@Valid @RequestBody Categorie categorie) {
        Categorie nouvelleCategorie = categorieService.ajouterCategorie(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleCategorie);
    }
}
