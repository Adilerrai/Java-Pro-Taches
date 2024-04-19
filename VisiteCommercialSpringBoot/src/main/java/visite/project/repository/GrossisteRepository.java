package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.model.Grossiste;

public interface GrossisteRepository extends JpaRepository<Grossiste, Long> {
    Grossiste findByNom(String nom);}
