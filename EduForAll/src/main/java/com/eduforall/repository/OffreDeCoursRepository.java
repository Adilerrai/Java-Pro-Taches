package com.eduforall.repository;

import com.eduforall.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreDeCoursRepository extends JpaRepository<Cours, Long> {
}
