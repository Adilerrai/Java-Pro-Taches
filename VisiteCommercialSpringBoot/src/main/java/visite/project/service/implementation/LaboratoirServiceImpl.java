package visite.project.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import visite.project.dto.LaboratoireDTO;
import visite.project.model.Laboratoire;
import visite.project.repository.LaboratoireRepository;
import visite.project.service.LaboratoireService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LaboratoirServiceImpl implements LaboratoireService {

    private final LaboratoireRepository laboratoireRepository;
    private final ModelMapper modelMapper;

    public LaboratoirServiceImpl(LaboratoireRepository laboratoireRepository, ModelMapper modelMapper) {
        this.laboratoireRepository = laboratoireRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LaboratoireDTO create(LaboratoireDTO laboratoireDTO) {
        Laboratoire laboratoire = modelMapper.map(laboratoireDTO, Laboratoire.class);
        laboratoire = laboratoireRepository.save(laboratoire);
        return modelMapper.map(laboratoire, LaboratoireDTO.class);
    }

    @Override
    public LaboratoireDTO update(LaboratoireDTO laboratoireDTO) {
        Laboratoire laboratoire = laboratoireRepository.findById(laboratoireDTO.getId()).get();
        if (laboratoire != null) {
            laboratoire.setNom(laboratoireDTO.getNom());
            laboratoire.setAdresse(laboratoireDTO.getAdresse());
            laboratoire.setTelephone(laboratoireDTO.getTelephone());
            laboratoire.setEmail(laboratoireDTO.getEmail());
            laboratoire.setVille(laboratoireDTO.getVille());
            laboratoire = laboratoireRepository.save(laboratoire);
            return modelMapper.map(laboratoire, LaboratoireDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        laboratoireRepository.deleteById(id);
    }

    @Override
    public LaboratoireDTO findById(Long id) {
        Laboratoire laboratoire = laboratoireRepository.findById(id).get();
        if (laboratoire != null) {
            return modelMapper.map(laboratoire, LaboratoireDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public LaboratoireDTO findByNom(String nom) {
        Laboratoire laboratoire = laboratoireRepository.findByNom(nom);
        if (laboratoire != null) {
            return modelMapper.map(laboratoire, LaboratoireDTO.class);
        }else {
            return null;
        }

    }

    @Override
    public List<LaboratoireDTO> findAll() {
        List<Laboratoire> laboratoires = laboratoireRepository.findAll();
        return laboratoires.stream().map(laboratoire -> modelMapper.map(laboratoire, LaboratoireDTO.class)).collect(Collectors.toList());
    }
}
