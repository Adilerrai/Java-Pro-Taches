package com.eduforall.repository;

import com.eduforall.model.Cours;
import com.eduforall.model.criteria.CoursCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomeCoursRepo {

    Iterable<Cours> findByCriteria(CoursCriteria CoursCriteria, Pageable pageable);

}
