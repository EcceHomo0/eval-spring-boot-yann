package com.example.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="produit")
public class Produit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le nom du produit ne doit pas être vide")
    @Size(min = 3, message = "Le nom du produit doit contenir plus de 2 caractères")
    @Column(name="nom", nullable = false, length = 50)
    private String nom;

    @NotNull(message = "Le prix du produit ne doit pas être vide")
    @Positive(message = "Le prix du produit doit être positif")
    @Column(name="prix", nullable = false)
    private Double prix;

    public Produit(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

}
