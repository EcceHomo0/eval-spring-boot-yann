package com.example.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le libellé de la catégorie ne doit pas être null")
    @Size(min = 2, message = "Le libellé de la catégorie doit contenir au moins 2 caractères")
    @Column(name = "libele", nullable = false, length = 50)
    private String libele;

    public Categorie(String libele) {
        this.libele = libele;
    }
}

