package com.example.invoice.service;

import com.example.invoice.dto.EnteteFactDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EnteteService {
    List<EnteteFactDTO> getAllEntetes();
    EnteteFactDTO getEnteteById(Long id);
    EnteteFactDTO saveEntete(EnteteFactDTO enteteDTO);
    void deleteEntete(Long id);
    EnteteFactDTO updateEntete(EnteteFactDTO enteteDTO);
}
