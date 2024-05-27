package com.example.invoice.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.List;



@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    @NotBlank(message = "Prenom cannot be blank")
    private String prenom;

    private String adresse;


    @Positive(message = "L'age doit être un nombre positif")
    private  int age;


    @Email(message="L'email doit être valide")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]{9}$", message = "Le numéro de téléphone doit être composé de 9 chiffres")
    private String telephone;

    @OneToMany
    private List<EnteteFact> enteteFacts;
    public Client() {
    }

    public Client(Long id, String nom, int age, String prenom, String adresse, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<EnteteFact> getEnteteFacts() {
        return enteteFacts;
    }

    public void setEnteteFacts(List<EnteteFact> enteteFacts) {
        this.enteteFacts = enteteFacts;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
