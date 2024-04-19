package visite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class EntrepriseDTO {

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
