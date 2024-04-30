package visite.project.repository;

import org.hibernate.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import visite.project.dto.CommercialCriteria;
import visite.project.model.Commercial;

public interface CommercialCustomRepo {

    Page<Commercial> findByCriteria(CommercialCriteria criteria , Pageable pageable);

}
