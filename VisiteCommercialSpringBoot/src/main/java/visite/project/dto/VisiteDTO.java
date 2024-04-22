package visite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visite.project.model.*;
import visite.project.model.enums.Status;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisiteDTO {
    private Long id;
    private LocalDate date;
    private String heure;
    private String objetDelavisite;
    private Status status;


    private Pharmacie pharmacie;
    private Grossiste grossiste;


    private Laboratoire laboratoire;


    private Commercial commercial;


    private Clinique clinique;


}
