package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.dto.PharamcieDTO;

import java.util.List;
@Service

public interface PharmacieService {
    PharamcieDTO create(PharamcieDTO pharamcieDTO);

    PharamcieDTO update(PharamcieDTO pharamcieDTO);
    void delete(Long id);
    PharamcieDTO findById(Long id);
    PharamcieDTO findByNom(String nom);
    List<PharamcieDTO> findAll();
}
