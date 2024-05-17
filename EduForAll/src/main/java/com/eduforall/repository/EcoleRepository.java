package com.eduforall.repository;

import com.eduforall.model.Cours;
import com.eduforall.model.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EcoleRepository extends JpaRepository<Ecole, Long> {
}
