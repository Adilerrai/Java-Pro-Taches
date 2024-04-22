package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.model.Pharmacie;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
    Pharmacie findByNom(String nom);
}
