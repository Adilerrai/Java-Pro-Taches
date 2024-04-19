package visite.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Entreprise {

    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    private String contact;
    private String secteur;
    private String nomGerant;
    private String ville;
    private String notes;


}
