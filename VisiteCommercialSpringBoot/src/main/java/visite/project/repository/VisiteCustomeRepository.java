package visite.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import visite.project.dto.CommercialCriteria;
import visite.project.dto.VisiteCriteria;
import visite.project.model.Commercial;
import visite.project.model.Visite;

public interface VisiteCustomeRepository {
    Page<Visite> findByCriteria(VisiteCriteria criteria , Pageable pageable);

}
