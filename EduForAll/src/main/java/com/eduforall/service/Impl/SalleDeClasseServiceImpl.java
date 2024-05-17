package com.eduforall.service.Impl;


import com.eduforall.dto.SalleDeClasseDTO;
import com.eduforall.model.SalleDeClasse;
import com.eduforall.repository.SalleDeClasseRepository;
import com.eduforall.service.SalleDeClasseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalleDeClasseServiceImpl implements SalleDeClasseService {

    @Autowired
    private SalleDeClasseRepository salleDeClasseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SalleDeClasseDTO save(SalleDeClasseDTO salleDeClasseDTO) {
        SalleDeClasse  salleDeClasse = modelMapper.map(salleDeClasseDTO, SalleDeClasse.class);
        salleDeClasseRepository.save(salleDeClasse);
        return modelMapper.map(salleDeClasse, SalleDeClasseDTO.class);
    }

    @Override
    public SalleDeClasseDTO update(SalleDeClasseDTO salleDeClasseDTO)
    {
        SalleDeClasse salleDeClasse = salleDeClasseRepository.findById(salleDeClasseDTO.getId()).get();
        if(salleDeClasse != null){
            salleDeClasse.setNomSalle(salleDeClasseDTO.getNomSalle());
            salleDeClasse.setNumeroSalle(salleDeClasseDTO.getNumeroSalle());
            salleDeClasse.setCapacite(salleDeClasseDTO.getCapacite());
            salleDeClasseRepository.save(salleDeClasse);
            return modelMapper.map(salleDeClasse, SalleDeClasseDTO.class);
        }else{
            return null;
        }

    }

    @Override
    public SalleDeClasseDTO getById(Long id) {
        SalleDeClasse salleDeClasse = salleDeClasseRepository.findById(id).get();
        return modelMapper.map(salleDeClasse, SalleDeClasseDTO.class);
    }

    @Override
    public void delete(Long id) {

        salleDeClasseRepository.deleteById(id);
    }

    @Override
    public SalleDeClasseDTO getByNom(String nom) {
        return null;
    }

    @Override
    public List<SalleDeClasseDTO> getAll() {
        List<SalleDeClasse> salles = salleDeClasseRepository.findAll();
        return salles.stream().map(salleDeClasse -> modelMapper.map(salleDeClasse, SalleDeClasseDTO.class)).collect(Collectors.toList());
    }


}
