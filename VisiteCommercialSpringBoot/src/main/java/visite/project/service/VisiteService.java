package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.dto.VisiteDTO;

import java.util.List;
@Service
public interface VisiteService {
    VisiteDTO create(VisiteDTO visiteDTO);
    VisiteDTO update(VisiteDTO visiteDTO);
    void delete(Long id);
    VisiteDTO findById(Long id);
    VisiteDTO findByNom(String nom);
    List<VisiteDTO> findAll();
}
