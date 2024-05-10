package visite.project.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import visite.project.dto.VisiteCriteria;
import visite.project.dto.VisiteDTO;
import visite.project.model.Visite;
import visite.project.model.enums.Status;
import visite.project.repository.VisiteRepository;
import visite.project.service.VisiteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisiteServiceImpl implements VisiteService {


    private final VisiteRepository visiteRepository;
    private final ModelMapper modelMapper;

    public VisiteServiceImpl(VisiteRepository visiteRepository, ModelMapper modelMapper) {
        this.visiteRepository = visiteRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public VisiteDTO create(VisiteDTO visiteDTO) {
        Visite visite = modelMapper.map(visiteDTO, Visite.class);
        visite = visiteRepository.save(visite);
        return modelMapper.map(visite, VisiteDTO.class);
    }

    @Override
    public VisiteDTO update(VisiteDTO visiteDTO) {
        Visite visite = visiteRepository.findById(visiteDTO.getId()).get();
        if (visite != null) {
            visite.setDate(visiteDTO.getDate());
            visite.setHeure(visiteDTO.getHeure());
            visite.setCommercial(visiteDTO.getCommercial());
            visite.setClinique(visiteDTO.getClinique());
            visite.setPharmacie(visiteDTO.getPharmacie());
            visite.setGrossiste(visiteDTO.getGrossiste());
            visite.setLaboratoire(visiteDTO.getLaboratoire());
            visite = visiteRepository.save(visite);
            return modelMapper.map(visite, VisiteDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        visiteRepository.deleteById(id);

    }

    @Override
    public VisiteDTO findById(Long id) {
        Visite visite = visiteRepository.findById(id).get();
        if (visite != null) {
            return modelMapper.map(visite, VisiteDTO.class);
        } else {
            return null;
        }
    }



    @Override
    public List<VisiteDTO> findAll() {
        List<Visite> visites = visiteRepository.findAll();
        return visites.stream().map(visite -> modelMapper.map(visite, VisiteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<VisiteDTO> findByCommercialId(Long id) {
        List<Visite> visites = visiteRepository.findByCommercialId(id);
        return visites.stream().map(visite -> modelMapper.map(visite, VisiteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<VisiteDTO> findByPharmacieId(Long id) {
        List<Visite> visites = visiteRepository.findByPharmacieId(id);
        return visites.stream().map(visite -> modelMapper.map(visite, VisiteDTO.class)).toList();    }

    @Override
    public List<VisiteDTO> findByCliniqueId(Long id) {
        List<Visite> visites = visiteRepository.findByCliniqueId(id);
        return visites.stream().map(visite -> modelMapper.map(visite, VisiteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<VisiteDTO> findByGrossisteId(Long id) {
        List<Visite> visites = visiteRepository.findByGrossisteId(id);
        return visites.stream().map(visite -> modelMapper.map(visite, VisiteDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<VisiteDTO> findByLaboratoireId(Long id) {
        List<Visite> visites = visiteRepository.findByLaboratoireId(id);
        return visites.stream().map(visite -> modelMapper.map(visite, VisiteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public VisiteDTO updateStatus(Long id, Status status) {
        Visite visite = visiteRepository.findById(id).get();
        if (visite != null) {
            visite.setStatus(status);
            visite = visiteRepository.save(visite);
            return modelMapper.map(visite, VisiteDTO.class);
        } else {
            return null;
        }

    }

    @Override
    public VisiteDTO findVisiteByCommercial(VisiteCriteria visiteCriteria, Pageable pageable) {

        return (VisiteDTO) visiteRepository.findByCriteria(visiteCriteria, pageable);
    }
}
