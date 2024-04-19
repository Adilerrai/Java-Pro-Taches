package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.dto.LaboratoireDTO;

import java.util.List;
@Service

public interface LaboratoireService {
    LaboratoireDTO create(LaboratoireDTO laboratoireDTO);
    LaboratoireDTO update(LaboratoireDTO laboratoireDTO);
    void delete(Long id);
    LaboratoireDTO findById(Long id);
    LaboratoireDTO findByNom(String nom);
    List<LaboratoireDTO> findAll();
}
