package com.eduforall.service;

import com.eduforall.dto.SalleDeClasseDTO;
import com.eduforall.model.SalleDeClasse;

import java.util.List;

public interface SalleDeClasseService  {

    SalleDeClasseDTO save(SalleDeClasseDTO salleDeClasseDTO);

    SalleDeClasseDTO update(SalleDeClasseDTO salleDeClasseDTO);

    SalleDeClasseDTO getById(Long id);

    void delete(Long id);

    SalleDeClasseDTO getByNom(String nom);

    List<SalleDeClasseDTO> getAll();

}
