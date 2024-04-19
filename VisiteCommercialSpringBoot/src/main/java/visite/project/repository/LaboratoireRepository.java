package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.model.Laboratoire;

public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {
}
