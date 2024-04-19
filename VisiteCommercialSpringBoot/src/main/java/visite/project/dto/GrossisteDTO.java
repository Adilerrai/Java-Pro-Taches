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
public class GrossisteDTO extends EntrepriseDTO{
    private long id;
    private String nomGerant;
    private String specialite;
    private int nbVendeur;


    private List<VisiteDTO> visites;
}
