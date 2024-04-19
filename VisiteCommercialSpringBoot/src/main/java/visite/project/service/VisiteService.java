package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.dto.VisiteDTO;
import visite.project.model.enums.Status;

import java.util.List;
@Service
public interface VisiteService {
    VisiteDTO create(VisiteDTO visiteDTO);
    VisiteDTO update(VisiteDTO visiteDTO);
    void delete(Long id);
    VisiteDTO findById(Long id);
    List<VisiteDTO> findAll();

    List<VisiteDTO> findByCommercialId(Long id);

    List<VisiteDTO> findByPharmacieId(Long id);

    List<VisiteDTO> findByCliniqueId(Long id);
    List<VisiteDTO> findByGrossisteId(Long id);
    List<VisiteDTO> findByLaboratoireId(Long id);
    VisiteDTO updateStatus(Long id, Status status);
}
