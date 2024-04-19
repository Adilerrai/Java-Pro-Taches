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
public class LaboratoireDTO extends EntrepriseDTO{
    private Long id ;
    private String specialite;

    private List<VisiteDTO> visites;
}
