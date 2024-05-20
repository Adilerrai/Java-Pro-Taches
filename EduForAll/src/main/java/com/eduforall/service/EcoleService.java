package com.eduforall.service;

import com.eduforall.dto.EcoleDTO;
import com.eduforall.model.criteria.EcoleCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EcoleService {

    EcoleDTO saveEcole(EcoleDTO ecoleDTO);

    EcoleDTO updateEcole(EcoleDTO ecoleDTO);

    EcoleDTO getEcoleById(Long id);

    void deleteEcole(Long id);

    List<EcoleDTO> getAllEcole();

    List<EcoleDTO> searchByCriteria(EcoleCriteria criteria, Pageable pageable);

    Object getEcole(Long id);
}
