package com.eduforall.service;

import com.eduforall.dto.EleveDTO;
import com.eduforall.model.criteria.EleveCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EleveService {

    EleveDTO save(EleveDTO eleveDTO);

    EleveDTO update(EleveDTO eleveDTO);

    EleveDTO getById(Long id);

    void delete(Long id);

    List<EleveDTO> getAll();


}
