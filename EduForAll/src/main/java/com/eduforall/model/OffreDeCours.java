package com.eduforall.model;


import com.eduforall.enums.Specialite;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offre_de_cours")
public class OffreDeCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private String description;

    private Date date;


    private String level;

    private int duration;

    @ManyToOne
    @JoinColumn(name = "professeur_id")

    private Professeur professeur;

    private Specialite specialite;

    public OffreDeCours(Long id, String subject, String description, String level, Date date, int duration, Professeur professeur, Specialite specialite) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.level = level;
        this.duration = duration;
        this.professeur = professeur;
        this.specialite = specialite;
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

public OffreDeCours() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
}
