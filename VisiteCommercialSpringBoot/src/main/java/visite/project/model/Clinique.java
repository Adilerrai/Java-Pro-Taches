package visite.project.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivilegedAction;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinique  extends Entreprise {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private int nbMedecin;
    private String specialite;
    @OneToMany(mappedBy = "clinique")
    @JsonIgnore
    private List<Visite> visites;

    public Clinique(int id) {
        this.id = id;
    }

}
