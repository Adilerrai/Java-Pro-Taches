package visite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visite.project.model.Entreprise;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrossisteDTO extends Entreprise {
    private Long id;
    private String nomGerant;
    private String specialite;
    private int nbVendeur;
    private List<VisiteDTO> visites;

}
