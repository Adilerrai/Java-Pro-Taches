import java.util.ArrayList;
import java.util.List;

abstract class Entreprise {
    private String nom;
    private List<Visite> visites = new ArrayList<>();

    public Entreprise(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void ajouterVisite(Visite visite) {
        visites.add(visite);
    }
}