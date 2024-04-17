class Visite {
    private Entreprise entreprise;
    private Commercial commercial;
    private String date;
    private String resultat;

    public Visite(Entreprise entreprise, Commercial commercial, String date) {
        this.entreprise = entreprise;
        this.commercial = commercial;
        this.date = date;
        this.resultat = "Planifiée";
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public Commercial getCommercial() {
        return commercial;
    }

    public String getDate() {
        return date;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}