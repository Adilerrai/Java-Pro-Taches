package com.eduforall.service;

import com.eduforall.dto.ProfesseurDTO;


import java.util.List;

public interface ProfesseurService {

    ProfesseurDTO save(ProfesseurDTO professeurDTO);

    ProfesseurDTO update(ProfesseurDTO professeurDTO);

    ProfesseurDTO getById(Long id);

    void delete(Long id);

    List<ProfesseurDTO> getAll();

}
