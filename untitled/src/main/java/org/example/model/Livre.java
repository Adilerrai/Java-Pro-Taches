package org.example.model;

import org.example.model.Enum.TypeLivre;

public  class Livre {
    private int id ;
    private String titre;
    private String Auteur; 
    private String  typeDuLivre;
    private long ISBN; 
    
    public Livre(int id, String titre, String auteur, String typeDuLivre, long iSBN) {
        this.id = id;
        this.titre = titre;
        Auteur = auteur;
        this.typeDuLivre = typeDuLivre;
        ISBN = iSBN;
    }

    public Livre() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    public String getTypeDuLivre() {
        return typeDuLivre;
    }

    public void setTypeDuLivre(String typeDuLivre) {
        this.typeDuLivre = typeDuLivre;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long iSBN) {
        ISBN = iSBN;
    }


    
}
