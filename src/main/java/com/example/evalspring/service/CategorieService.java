package com.example.evalspring.service;

import com.example.evalspring.exception.CategorieCreationFailedException;
import com.example.evalspring.exception.CategorieNotFoundException;
import com.example.evalspring.model.Categorie;
import com.example.evalspring.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie ajouterCategorie(Categorie categorie) {
        try {
            return categorieRepository.save(categorie);
        } catch (Exception e) {
            throw new CategorieCreationFailedException("Erreur lors de la création de la catégorie : " + e.getMessage());
        }
    }

    public List<Categorie> recupererToutesLesCategories() {
        return categorieRepository.findAll();
    }

    public Categorie recupererCategorieParId(Integer id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException("Catégorie avec l'ID " + id + " introuvable"));
    }
}

