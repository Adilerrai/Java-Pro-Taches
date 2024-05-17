package com.eduforall.repository;

import com.eduforall.model.Cours;
import com.eduforall.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EleveRepository extends JpaRepository<Eleve, Long> {
}
