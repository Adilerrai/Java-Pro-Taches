package com.eduforall.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cours")
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String description;
    private String level;
    private int duration;


    private String date;
    @ManyToOne
    private Ecole ecole;

    @ManyToOne
    private Professeur professeur;
    @ManyToMany
    private List<Eleve> eleves;

    public String getDescription() {
        return description;
    }

    public Cours(Long id, String subject, String description, String level, int duration, String date, Ecole ecole, Professeur professeur, List<Eleve> eleves) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.level = level;
        this.duration = duration;
        this.date = date;
        this.ecole = ecole;
        this.professeur = professeur;
        this.eleves = eleves;
    }

    public Cours() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription(String description) {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
}
