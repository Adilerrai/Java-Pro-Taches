import java.util.HashMap;
import java.util.Map;

class Commercial {
    private String nom;
    private Map<Visite, String> visites = new HashMap<>();

    public Commercial(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Map<Visite, String> getVisites() {
        return visites;
    }

    public void ajouterVisite(Visite visite, String statut) {
        visites.put(visite, statut);
    }

    public void mettreAJourStatut(Visite visite, String nouveauStatut) {
        visites.put(visite, nouveauStatut);
    }
}