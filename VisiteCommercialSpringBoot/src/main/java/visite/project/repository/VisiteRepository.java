package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.model.Visite;

import java.util.List;

public interface VisiteRepository extends JpaRepository<Visite, Long> {

    List<Visite> findByCommercialId(Long id);

    List<Visite> findByPharmacieId(Long id);

    List<Visite> findByCliniqueId(Long id);
    List<Visite> findByGrossisteId(Long id);
    List<Visite> findByLaboratoireId(Long id);

}
