package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.model.Visite;

public interface VisiteRepository extends JpaRepository<Visite, Long> {
}
