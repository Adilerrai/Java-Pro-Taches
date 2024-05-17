package com.eduforall.service;

import com.eduforall.dto.CoursDTO;
import com.eduforall.model.criteria.CoursCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoursService {
    CoursDTO saveCours(CoursDTO coursDTO);

    CoursDTO updateCours(CoursDTO coursDTO);

    CoursDTO getCoursById(Long id);

    void deleteCours(Long id);

    List<CoursDTO> searchByCriteria(CoursCriteria criteria, Pageable pageable);

    List<CoursDTO> getAllCours();
}
