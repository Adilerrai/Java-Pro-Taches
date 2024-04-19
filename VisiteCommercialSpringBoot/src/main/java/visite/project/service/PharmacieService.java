package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.dto.PharmacieDTO;

import java.util.List;
@Service

public interface PharmacieService {
    PharmacieDTO create(PharmacieDTO pharamcieDTO);

    PharmacieDTO update(PharmacieDTO pharamcieDTO);
    void delete(Long id);
    PharmacieDTO findById(Long id);
    PharmacieDTO findByNom(String nom);
    List<PharmacieDTO> findAll();
}
