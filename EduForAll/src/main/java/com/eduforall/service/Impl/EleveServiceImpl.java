package com.eduforall.service.Impl;

import com.eduforall.dto.EleveDTO;
import com.eduforall.model.Eleve;
import com.eduforall.model.criteria.EleveCriteria;
import com.eduforall.repository.EleveRepository;
import com.eduforall.service.EleveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EleveServiceImpl implements EleveService {

    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EleveDTO save(EleveDTO eleveDTO) {
        Eleve eleve = modelMapper.map(eleveDTO, Eleve.class);
        eleveRepository.save(eleve);
        return modelMapper.map(eleve, EleveDTO.class);
    }

    @Override
    public EleveDTO update(EleveDTO eleveDTO) {

        Eleve eleve = eleveRepository.findById(eleveDTO.getId()).get();
        if(eleve != null){
            eleve.setNom(eleveDTO.getNom());
            eleve.setPrenom(eleveDTO.getPrenom());
            eleve.setTelephone(eleveDTO.getTelephone());
            eleve.setEmail(eleveDTO.getEmail());
            eleve.setNiveau(eleveDTO.getNiveau());
            eleve.setCours(eleveDTO.getCours());
            eleveRepository.save(eleve);
            return modelMapper.map(eleve, EleveDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public EleveDTO getById(Long id) {
        Eleve eleve = eleveRepository.findById(id).get();
        return modelMapper.map(eleve, EleveDTO.class);
    }

    @Override
    public void delete(Long id) {
        eleveRepository.deleteById(id);
    }

    @Override
    public List<EleveDTO> getAll() {
        List<Eleve> eleves = eleveRepository.findAll();
        return eleves.stream().map(eleve -> modelMapper.map(eleve, EleveDTO.class)).collect(Collectors.toList());
    }


}
