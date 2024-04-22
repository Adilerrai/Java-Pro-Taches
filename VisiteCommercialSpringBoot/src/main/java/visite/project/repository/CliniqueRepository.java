package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.model.Clinique;

public interface CliniqueRepository extends JpaRepository<Clinique, Long> {
    Clinique findByNom(String nom);
}
