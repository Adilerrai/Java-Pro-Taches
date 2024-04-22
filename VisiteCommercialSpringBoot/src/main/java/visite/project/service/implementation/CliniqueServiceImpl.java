package visite.project.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import visite.project.dto.CliniqueDTO;
import visite.project.model.Clinique;
import visite.project.repository.CliniqueRepository;
import visite.project.service.CliniqueService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CliniqueServiceImpl implements CliniqueService {

    private final CliniqueRepository cliniqueRepository;
    private final ModelMapper modelMapper;
    public CliniqueServiceImpl(CliniqueRepository cliniqueRepository, ModelMapper modelMapper) {
        this.cliniqueRepository = cliniqueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CliniqueDTO save(CliniqueDTO cliniqueDTO) {
        Clinique clinique = modelMapper.map(cliniqueDTO, Clinique.class);
        clinique = cliniqueRepository.save(clinique);
        return modelMapper.map(clinique, CliniqueDTO.class);
    }

    @Override
    public CliniqueDTO findById(Long id) {
        Clinique clinique = cliniqueRepository.findById(id).get();
        if (clinique != null) {
            return modelMapper.map(clinique, CliniqueDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public CliniqueDTO update(CliniqueDTO cliniqueDTO) {
        Clinique clinique = cliniqueRepository.findById((long) cliniqueDTO.getId()).get();
        if (clinique != null) {
            clinique.setNom(cliniqueDTO.getNom());
            clinique.setAdresse(cliniqueDTO.getAdresse());
            clinique.setTelephone(cliniqueDTO.getTelephone());
            clinique.setEmail(cliniqueDTO.getEmail());
            clinique.setVille(cliniqueDTO.getVille());
            clinique = cliniqueRepository.save(clinique);
            return modelMapper.map(clinique, CliniqueDTO.class);
        } else {
            return null;
        }

    }

    @Override
    public void delete(Long id) {
        cliniqueRepository.deleteById(id);

    }

    @Override
    public List<CliniqueDTO> findAll() {
        List<Clinique> cliniques = cliniqueRepository.findAll();
        return cliniques.stream().map(clinique -> modelMapper.map(clinique, CliniqueDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CliniqueDTO findByNom(String nom) {
        Clinique clinique = cliniqueRepository.findByNom(nom);
        if (clinique != null) {
            return modelMapper.map(clinique, CliniqueDTO.class);
        } else {
            return null;
        }
    }
}
