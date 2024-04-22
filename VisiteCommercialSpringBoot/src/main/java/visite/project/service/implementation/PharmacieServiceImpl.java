package visite.project.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import visite.project.dto.PharmacieDTO;
import visite.project.model.Pharmacie;
import visite.project.repository.PharmacieRepository;
import visite.project.service.PharmacieService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PharmacieServiceImpl implements PharmacieService {

    private final PharmacieRepository pharmacieRepository;
    private final ModelMapper modelMapper;
    public PharmacieServiceImpl(ModelMapper modelMapper, PharmacieRepository pharmacieRepository) {
        this.modelMapper = modelMapper;
        this.pharmacieRepository = pharmacieRepository;
    }
    @Override
    public PharmacieDTO create(PharmacieDTO pharamcieDTO) {
        Pharmacie  pharmacie = modelMapper.map(pharamcieDTO, Pharmacie.class);
        pharmacie = pharmacieRepository.save(pharmacie);
        return modelMapper.map(pharmacie, PharmacieDTO.class);
    }

    @Override
    public PharmacieDTO update(PharmacieDTO pharamcieDTO) {
        Pharmacie pharmacie = pharmacieRepository.findById(pharamcieDTO.getId()).get();
        if (pharmacie != null) {
            pharmacie.setNom(pharamcieDTO.getNom());
            pharmacie.setAdresse(pharamcieDTO.getAdresse());
            pharmacie.setTelephone(pharamcieDTO.getTelephone());
            pharmacie.setEmail(pharamcieDTO.getEmail());
            pharmacie.setVille(pharamcieDTO.getVille());
            pharmacie = pharmacieRepository.save(pharmacie);
            return modelMapper.map(pharmacie, PharmacieDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        pharmacieRepository.deleteById(id);
    }

    @Override
    public PharmacieDTO findById(Long id) {
        Pharmacie pharmacie = pharmacieRepository.findById(id).get();
        if (pharmacie != null) {
            return modelMapper.map(pharmacie, PharmacieDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public PharmacieDTO findByNom(String nom) {
        Pharmacie pharmacie = pharmacieRepository.findByNom(nom);
        if (pharmacie != null) {
            return modelMapper.map(pharmacie, PharmacieDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public List<PharmacieDTO> findAll() {
        List<Pharmacie> pharmacieDTOS = pharmacieRepository.findAll();
        return pharmacieDTOS.stream().map(pharmacie -> modelMapper.map(pharmacie, PharmacieDTO.class)).collect(Collectors.toList());

    }
}
