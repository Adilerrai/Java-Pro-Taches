package visite.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commercial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private long  matricule;
    public Commercial(long id) {
        this.id = id;
    }


    @OneToMany(mappedBy = "commercial")
    @JsonIgnore
    private List<Visite> visites;

    public Commercial(long id ,String nom, String prenom, String email, String telephone, String adresse, long matricule) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "Commercial{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", matricule=" + matricule +
                '}';
    }

}
