package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.dto.LaboratoireDTO;
import visite.project.model.Laboratoire;

public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {
    Laboratoire findByNom(String nom);
}
