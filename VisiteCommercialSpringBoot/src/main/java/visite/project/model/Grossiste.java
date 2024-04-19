package visite.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "grossiste")
@NoArgsConstructor
@AllArgsConstructor
public class Grossiste extends Entreprise {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        private String nomGerant;
        private String specialite;
        private int nbVendeur;

        @OneToMany(mappedBy = "grossiste")
        private List<Visite> visites;

}
