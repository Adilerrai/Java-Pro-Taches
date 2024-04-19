package visite.project.service;

import visite.project.dto.CommercialDTO;

public interface CommercialService {
    CommercialDTO creat(CommercialDTO commercialDTO);

    CommercialDTO update(CommercialDTO commercialDTO);
    CommercialDTO findById(Long id);
    void delete(Long id);
    CommercialDTO findByNom(String nom);
    CommercialDTO findByMatricule(Long matricule);

}
