package com.eduforall.repository;

import com.eduforall.model.Cours;
import com.eduforall.model.SalleDeClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SalleDeClasseRepository extends JpaRepository<SalleDeClasse, Long> {
}
