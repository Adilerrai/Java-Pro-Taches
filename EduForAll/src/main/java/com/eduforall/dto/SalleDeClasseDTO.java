package com.eduforall.dto;

import com.eduforall.model.Ecole;


public class SalleDeClasseDTO {

    private Long id;

    private String nomSalle;

    private int numeroSalle;


    private Ecole ecole;


    private int capacite;

    public SalleDeClasseDTO(Long id, String nomSalle, int numeroSalle, Ecole ecole, int capacite) {
        this.id = id;
        this.nomSalle = nomSalle;
        this.numeroSalle = numeroSalle;
        this.ecole = ecole;
        this.capacite = capacite;
    }


    public SalleDeClasseDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public int getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(int numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
