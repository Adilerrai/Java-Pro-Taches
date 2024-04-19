package visite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CliniqueDTO extends EntrepriseDTO{

    private Long id;
    private int nbMedecin;
    private String specialite;
    private List<VisiteDTO> visites;
}
