package visite.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visite.project.model.Entreprise;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor

public class Laboratoire extends Entreprise {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    private String specialite;
    @OneToMany(mappedBy = "laboratoire")
    private List<Visite> visites;
}
