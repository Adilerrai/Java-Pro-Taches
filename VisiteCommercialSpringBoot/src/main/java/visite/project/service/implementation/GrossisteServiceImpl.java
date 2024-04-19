package visite.project.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import visite.project.dto.GrossisteDTO;
import visite.project.model.Grossiste;
import visite.project.repository.GrossisteRepository;
import visite.project.service.GrossisteService;

import java.util.List;


@Service
@Transactional
public class GrossisteServiceImpl  implements GrossisteService {


    private final GrossisteRepository grossisteRepository;
    private final ModelMapper modelMapper;

    public GrossisteServiceImpl(GrossisteRepository grossisteRepository, ModelMapper modelMapper) {
        this.grossisteRepository = grossisteRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public GrossisteDTO create(GrossisteDTO grossisteDTO) {
        Grossiste grossiste = modelMapper.map(grossisteDTO, Grossiste.class);
        grossiste = grossisteRepository.save(grossiste);
        return modelMapper.map(grossiste, GrossisteDTO.class);
    }

    @Override
    public GrossisteDTO update(GrossisteDTO grossisteDTO) {
        Grossiste grossiste = grossisteRepository.findById(grossisteDTO.getId()).get();
        if (grossiste != null) {
            grossiste.setNom(grossisteDTO.getNom());
            grossiste.setAdresse(grossisteDTO.getAdresse());
            grossiste.setTelephone(grossisteDTO.getTelephone());
            grossiste.setEmail(grossisteDTO.getEmail());
            grossiste.setVille(grossisteDTO.getVille());
            grossiste.setNomGerant(grossisteDTO.getNomGerant());
            grossiste = grossisteRepository.save(grossiste);
            return modelMapper.map(grossiste, GrossisteDTO.class);
        } else {
            return null;

        }

    }

    @Override
    public void delete(Long id) {
        grossisteRepository.deleteById(id);
    }

    @Override
    public GrossisteDTO findById(Long id) {
        Grossiste grossiste = grossisteRepository.findById(id).get();
        if (grossiste != null) {
            return modelMapper.map(grossiste, GrossisteDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public GrossisteDTO findByNom(String nom) {
        Grossiste grossiste = grossisteRepository.findByNom(nom);
        if (grossiste != null) {
            return modelMapper.map(grossiste, GrossisteDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<GrossisteDTO> findAll() {
        List<Grossiste> grossistes = grossisteRepository.findAll();
        return grossistes.stream().map(grossiste -> modelMapper.map(grossiste, GrossisteDTO.class)).toList();
    }
}
