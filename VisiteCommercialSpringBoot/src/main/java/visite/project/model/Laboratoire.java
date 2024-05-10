package visite.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id ;
    private String specialite;
    @OneToMany(mappedBy = "laboratoire", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Visite> visites;

    public Laboratoire(long id) {
        this.id = id;
    }
}
