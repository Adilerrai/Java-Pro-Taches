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
@Table(name = "visite")
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String heure;
    private String objetDelavisite;
    private Status status;

    @ManyToOne
    @JoinColumn(name="pharmacie_id", referencedColumnName="id" )
    private Pharmacie pharmacie;
    @ManyToOne
    private Grossiste grossiste;

    @ManyToOne
    private Laboratoire laboratoire;

    @ManyToOne
    @JoinColumn(name="commercial_id", referencedColumnName="id" )
    private Commercial commercial;

    @ManyToOne
    private Clinique clinique;
}
