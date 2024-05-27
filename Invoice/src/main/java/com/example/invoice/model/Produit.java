package com.example.invoice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Produit {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Designation cannot be null")
    @Size(min = 1, max = 100, message = "Designation must be between 1 and 100 characters")
    private String designation;

    @NotNull(message = "Prix Unitaire cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Prix Unitaire must be greater than 0")
    private BigDecimal prixUnitaire;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;


    public Produit(Long id, String designation, BigDecimal prixUnitaire, String description) {
        this.id = id;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.description = description;
    }

    public Produit() {

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
