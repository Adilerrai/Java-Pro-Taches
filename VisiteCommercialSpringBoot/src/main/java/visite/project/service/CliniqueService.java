package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.dto.CliniqueDTO;

import java.util.List;

@Service
public interface CliniqueService {
    CliniqueDTO save(CliniqueDTO cliniqueDTO);
    CliniqueDTO findById(Long id);
    CliniqueDTO update(CliniqueDTO cliniqueDTO);
    void delete(Long id);
    List<CliniqueDTO> findAll();

    CliniqueDTO findByNom(String nom);
}
