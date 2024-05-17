package com.eduforall.repository;

import com.eduforall.model.Cours;
import com.eduforall.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
