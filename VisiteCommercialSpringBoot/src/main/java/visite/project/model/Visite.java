package visite.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visite.project.model.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String heure;
    private String objetDelavisite;
    private Status status;

    @ManyToOne
    private Pharmacie pharmacie;
    @ManyToOne
    private Grossiste grossiste;

    @ManyToOne
    private Laboratoire laboratoire;

    @ManyToOne
    private Commercial commercial;

    @ManyToOne
    private Clinique clinique;
}
