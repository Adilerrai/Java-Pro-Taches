package com.eduforall.service.Impl;

import com.eduforall.dto.ProfesseurDTO;
import com.eduforall.model.Professeur;
import com.eduforall.repository.ProfesseurRepository;
import com.eduforall.service.ProfesseurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProfesseurServiceImpl implements ProfesseurService {

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private ProfesseurRepository professeurRepository;

    @Override
    public ProfesseurDTO save(ProfesseurDTO professeurDTO) {
        Professeur professeur = modelMapper.map(professeurDTO, Professeur.class);
        professeurRepository.save(professeur);
        return modelMapper.map(professeur, ProfesseurDTO.class);
    }

    @Override
    public ProfesseurDTO update(ProfesseurDTO professeurDTO) {
        Professeur professeur = professeurRepository.findById(professeurDTO.getId()).get();
        if(professeur != null){
            professeur.setNom(professeurDTO.getNom());
            professeur.setPrenom(professeurDTO.getPrenom());
            professeur.setCours(professeurDTO.getCours());
            professeur.setTelephone(professeurDTO.getTelephone());
            professeur.setEmail(professeurDTO.getEmail());
            professeur.setSpecialite(professeurDTO.getSpecialite());
            professeurRepository.save(professeur);
            return modelMapper.map(professeur, ProfesseurDTO.class);
    }else {
        return null;
    }
}

    @Override
    public ProfesseurDTO getById(Long id) {
        Professeur professeur = professeurRepository.findById(id).get();
        return modelMapper.map(professeur, ProfesseurDTO.class);

    }

    @Override
    public void delete(Long id) {
        professeurRepository.deleteById(id);
    }

    @Override
    public List<ProfesseurDTO> getAll() {
        List<Professeur> professeurs = professeurRepository.findAll();
        List<ProfesseurDTO> professeurDTOS = new ArrayList<>();
        for (Professeur professeur : professeurs) {
            ProfesseurDTO professeurDTO = modelMapper.map(professeur, ProfesseurDTO.class);
            professeurDTOS.add(professeurDTO);
        }
        return professeurDTOS;
    }


}
