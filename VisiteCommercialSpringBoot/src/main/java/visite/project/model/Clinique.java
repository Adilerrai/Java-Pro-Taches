package visite.project.model;


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
    private List<Visite> visites;

}
