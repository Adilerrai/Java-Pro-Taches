package com.eduforall.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ecole")
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomEcole;
    private String adresse;
    private String telephone;
    private String email;


    @OneToMany
    @JoinColumn(name = "salle_id")
    private List<SalleDeClasse> salles;


    @OneToMany
    private List<Cours> cours;

    public Ecole(Long id, String nomEcole, String adresse,List<Cours> cours ,String telephone, String email , List<SalleDeClasse> salles) {
        this.id = id;
        this.nomEcole = nomEcole;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.salles = salles;
        this.cours = cours;
    }

    public Ecole() {
    }

    public Long getId() {
        return id;
    }


    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public List<SalleDeClasse> getSalles() {
        return salles;
    }

    public void setSalles(List<SalleDeClasse> salles) {
        this.salles = salles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEcole() {
        return nomEcole;
    }

    public void setNomEcole(String nomEcole) {
        this.nomEcole = nomEcole;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
