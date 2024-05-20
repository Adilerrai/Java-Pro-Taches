package com.eduforall.repository;

import com.eduforall.model.Ecole;
import com.eduforall.model.criteria.EcoleCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomeEcoleRepo {

    Iterable<Ecole> findByCriteria(EcoleCriteria ecoleCriteria, Pageable pageable);
}
