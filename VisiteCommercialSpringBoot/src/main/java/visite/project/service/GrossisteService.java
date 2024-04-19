package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.dto.GrossisteDTO;

import java.util.List;

@Service
public interface GrossisteService {
    GrossisteDTO create(GrossisteDTO grossisteDTO);
    GrossisteDTO update(GrossisteDTO grossisteDTO);
    void delete(Long id);
    GrossisteDTO findById(Long id);
    GrossisteDTO findByNom(String nom);

    List<GrossisteDTO> findAll();

}
