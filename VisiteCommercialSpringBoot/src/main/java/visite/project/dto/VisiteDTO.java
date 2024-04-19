package visite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visite.project.model.*;
import visite.project.model.enums.Status;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisiteDTO {
    private int id;
    private LocalDate date;
    private String heure;
    private String objetDelavisite;
    private Status status;


    private PharamcieDTO pharmacie;
    private GrossisteDTO grossiste;


    private LaboratoireDTO laboratoire;


    private CommercialDTO commercial;


    private CliniqueDTO clinique;


}
