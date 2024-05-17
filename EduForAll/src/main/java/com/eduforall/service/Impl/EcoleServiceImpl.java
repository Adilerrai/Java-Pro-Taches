package com.eduforall.service.Impl;

import com.eduforall.dto.CoursDTO;
import com.eduforall.dto.EcoleDTO;
import com.eduforall.model.Cours;
import com.eduforall.model.Ecole;
import com.eduforall.model.criteria.EcoleCriteria;
import com.eduforall.repository.CustomeEcoleRepo;
import com.eduforall.repository.EcoleRepository;
import com.eduforall.service.EcoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class EcoleServiceImpl implements EcoleService {


    @Autowired
    private EcoleRepository ecoleRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Autowired
    private CustomeEcoleRepo customEcoleRepo;

    @Override
    public EcoleDTO saveEcole(EcoleDTO ecoleDTO) {
        Ecole ecole = modelMapper.map(ecoleDTO, Ecole.class);
        ecoleRepository.save(ecole);
        return modelMapper.map(ecole, EcoleDTO.class);
    }

    @Override
    public EcoleDTO updateEcole(EcoleDTO ecoleDTO) {
        Ecole ecole = ecoleRepository.findById(ecoleDTO.getId()).get();
        if(ecole != null){
            ecole.setNomEcole(ecoleDTO.getNomEcole());
            ecole.setAdresse(ecoleDTO.getAdresse()) ;
            ecole.setCours(ecoleDTO.getCours());
            ecole.setEmail(ecoleDTO.getEmail());
            ecole.setSalles(ecoleDTO.getSalles());
            ecole.setTelephone(ecoleDTO.getTelephone());
            ecoleRepository.save(ecole);
            return modelMapper.map(ecole, EcoleDTO.class);
            }else{
                return null;
        }

    }

    @Override
    public EcoleDTO getEcoleById(Long id) {
        Ecole ecole = ecoleRepository.findById(id).get();
        return modelMapper.map(ecole, EcoleDTO.class);
    }

    @Override
    public void deleteEcole(Long id) {
        ecoleRepository.deleteById(id);

    }

    @Override
    public List<EcoleDTO> getAllEcole() {
        List<Ecole> ecoles = ecoleRepository.findAll();
        return ecoles.stream().map(ecole -> modelMapper.map(ecole, EcoleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EcoleDTO> searchByCriteria(EcoleCriteria criteria, Pageable pageable) {

        Iterable<Ecole> ecoles = customEcoleRepo.findByCriteria(criteria , null);
        Iterator<Ecole> iterator = ecoles.iterator();
        List<EcoleDTO> ecoleDTOS = new ArrayList<>();
        while (iterator.hasNext()){
            Ecole ecole1 = iterator.next();
            EcoleDTO ecole = modelMapper.map(ecole1, EcoleDTO.class);
            ecoleDTOS.add(ecole);
        }
        return ecoleDTOS;

}

    @Override
    public Object getEcole(Long id) {
    Ecole ecole = ecoleRepository.findById(id).get();
        return modelMapper.map(ecole, EcoleDTO.class);
}
}
