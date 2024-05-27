package com.example.invoice.service;

import com.example.invoice.dto.EnteteFactDTO;

import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteFact;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;


import java.util.List;
@Service
public interface EnteteService {
    List<EnteteFactDTO> getAllEntetes();
    EnteteFactDTO getEnteteById(Long id);
    EnteteFactDTO saveEntete(EnteteFactDTO enteteDTO);
    void deleteEntete(Long id);
    EnteteFactDTO updateEntete(EnteteFactDTO enteteDTO);

    Page<EnteteFact> searchMultiple(EnteteRechercheDTO enteteFactDTO, Pageable pageable);
}
