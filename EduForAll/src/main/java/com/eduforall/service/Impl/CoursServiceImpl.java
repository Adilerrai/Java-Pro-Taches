package com.eduforall.service.Impl;

import com.eduforall.dto.CoursDTO;
import com.eduforall.model.Cours;
import com.eduforall.model.criteria.CoursCriteria;
import com.eduforall.repository.CoursRepository;

import com.eduforall.repository.CustomeCoursRepo;
import com.eduforall.service.CoursService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomeCoursRepo customeCoursRepo;

    @Override
    public CoursDTO saveCours(CoursDTO coursDTO) {
        Cours cours1 = modelMapper.map(coursDTO, Cours.class);
        System.out.println("cours1 = " + cours1);
        coursRepository.save(cours1);
        return modelMapper.map(cours1, CoursDTO.class);
    }
    @Override

    public CoursDTO updateCours(CoursDTO coursDTO) {
        Cours cours1 = coursRepository.findById(coursDTO.getId()).get();

        if (cours1 != null) {
            cours1.setProfesseur(coursDTO.getProfesseur());
            cours1.setEleves(coursDTO.getEleves());
            cours1.setSubject(coursDTO.getSubject());
            cours1.setEcole(coursDTO.getEcole());
            cours1.getDescription(coursDTO.getDescription());
            cours1.setDuration(coursDTO.getDuration());
            cours1.setLevel(coursDTO.getLevel());
            cours1.setDate(coursDTO.getDate());
            coursRepository.save(cours1);
            CoursDTO coursDTO1 = modelMapper.map(cours1, CoursDTO.class);
            return coursDTO1;
        } else {
            return null;
        }
    }
    @Override
    public CoursDTO getCoursById(Long id) {
        Optional<Cours> cours = coursRepository.findById(id);
        if (cours.isPresent()) {
            return modelMapper.map(cours.get(), CoursDTO.class);
        } else {
            return null;
        }
    }
    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
    @Override
   public List<CoursDTO> searchByCriteria(CoursCriteria criteria, Pageable pageable){
       Iterable<Cours> cours = customeCoursRepo.findByCriteria(criteria , null);
         Iterator<Cours> iterator = cours.iterator();
            List<CoursDTO> coursDTOS = new ArrayList<>();
            while (iterator.hasNext()){
                Cours cours1 = iterator.next();
                CoursDTO coursDTO = modelMapper.map(cours1, CoursDTO.class);
                coursDTOS.add(coursDTO);
            }
            return coursDTOS;
   }
    @Override
    public List<CoursDTO> getAllCours() {
        List<Cours> cours = coursRepository.findAll();
        return cours.stream().map(cours1 -> modelMapper.map(cours1, CoursDTO.class)).collect(Collectors.toList());

    }
}
