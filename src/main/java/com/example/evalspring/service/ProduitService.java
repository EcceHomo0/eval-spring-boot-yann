package com.example.evalspring.service;

import com.example.evalspring.exception.ProduitCreationFailedException;
import com.example.evalspring.exception.ProduitNotFoundException;
import com.example.evalspring.model.Produit;
import com.example.evalspring.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit ajouterProduit(Produit produit) {
        try {
            return produitRepository.save(produit);
        } catch (Exception e) {
            throw new ProduitCreationFailedException("Erreur lors de la création du produit : " + e.getMessage());
        }
    }

    public List<Produit> recupererTousLesProduits() {
        List<Produit> produits = new ArrayList<>();
        produitRepository.findAll().forEach(produits::add);
        return produits;

    }

    public Produit recupererProduitParId(Integer id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException("Produit avec l'ID " + id + " introuvable"));
    }
}
