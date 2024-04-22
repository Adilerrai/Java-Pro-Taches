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
    @JoinColumn(name="grossiste_id", referencedColumnName="id" )
    private Grossiste grossiste;

    @ManyToOne
    @JoinColumn(name="laboratoire_id", referencedColumnName="id" )
    private Laboratoire laboratoire;

    @ManyToOne
    @JoinColumn(name="commercial_id", referencedColumnName="id" )
    private Commercial commercial;

    @ManyToOne
    @JoinColumn(name="clinique_id", referencedColumnName="id" )
    private Clinique clinique;

    @Override
    public String toString() {
        return "Visite{" +
                "id=" + id +
                ", date=" + date +
                ", heure='" + heure + '\'' +
                ", objetDelavisite='" + objetDelavisite + '\'' +
                ", status=" + status +
                ", pharmacie=" + (pharmacie != null ? pharmacie.getId() : null) +
                ", grossiste=" + (grossiste != null ? grossiste.getId() : null) +
                ", laboratoire=" + (laboratoire != null ? laboratoire.getId() : null) +
                ", commercial=" + (commercial != null ? commercial.getId() : null) +
                ", clinique=" + (clinique != null ? clinique.getId() : null) +
                '}';
    }
}
