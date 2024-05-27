package com.example.invoice.repository;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnteteCriteriaRepo {


    Page<EnteteFactDTO> findByCriteria(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable);

}
