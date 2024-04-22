package visite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visite.project.model.Visite;

import javax.persistence.OneToMany;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommercialDTO {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private long  matricule;
    private List<Visite> visites;
}
