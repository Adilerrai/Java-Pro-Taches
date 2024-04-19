package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.model.Commercial;

public interface CommercialRepository  extends JpaRepository<Commercial, Long> {
    Commercial findByNom(String nom);
    Commercial findByMatricule(Long  Matricule);
}
