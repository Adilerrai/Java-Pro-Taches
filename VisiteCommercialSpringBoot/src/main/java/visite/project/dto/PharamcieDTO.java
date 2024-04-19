package visite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visite.project.model.Visite;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharamcieDTO extends EntrepriseDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    private List<VisiteDTO> visites;
}
