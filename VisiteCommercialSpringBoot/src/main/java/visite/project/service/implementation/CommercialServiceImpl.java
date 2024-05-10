//package visite.project.service.implementation;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import visite.project.dto.CommercialDTO;
//import visite.project.model.Commercial;
//import visite.project.repository.CommercialRepository;
//import visite.project.service.CommercialService;
//
//@Service
//public class CommercialServiceImpl implements CommercialService {
//
//    private final CommercialRepository commercialRepository;
//    private final ModelMapper modelMapper;
//
//    public CommercialServiceImpl(CommercialRepository commercialRepository, ModelMapper modelMapper) {
//        this.commercialRepository = commercialRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public CommercialDTO creat(CommercialDTO commercialDTO) {
//        Commercial commercial = modelMapper.map(commercialDTO, Commercial.class);
//        commercial = commercialRepository.save(commercial);
//        return modelMapper.map(commercial, CommercialDTO.class);
//    }
//
//    @Override
//    public CommercialDTO update(CommercialDTO commercialDTO) {
//        Commercial commercial = commercialRepository.findById(commercialDTO.getId()).get();
//        if (commercial != null) {
//            commercial.setNom(commercialDTO.getNom());
//            commercial.setPrenom(commercialDTO.getPrenom());
//            commercial.setAdresse(commercialDTO.getAdresse());
//            commercial.setTelephone(commercialDTO.getTelephone());
//            commercial.setEmail(commercialDTO.getEmail());
//            commercial.setMatricule(commercialDTO.getMatricule());
//            commercial.setVisites(commercialDTO.getVisites());
//            commercial = commercialRepository.save(commercial);
//            return modelMapper.map(commercial, CommercialDTO.class);
//        }else {
//            return null;
//        }
//    }
//
//    @Override
//    public CommercialDTO findById(Long id) {
//        Commercial commercial = commercialRepository.findById(id).get();
//        if (commercial != null) {
//            return modelMapper.map(commercial, CommercialDTO.class);
//        }else {
//            return null;
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        commercialRepository.deleteById(id);
//    }
//
//    @Override
//    public CommercialDTO findByNom(String nom) {
//        Commercial commercial = commercialRepository.findByNom(nom);
//        if (commercial != null) {
//            return modelMapper.map(commercial, CommercialDTO.class);
//        }else {
//            return null;
//        }
//    }
//
//    @Override
//    public CommercialDTO findByMatricule(Long Matricule) {
//        Commercial commercial = commercialRepository.findByMatricule(Matricule);
//        if (commercial != null) {
//            return modelMapper.map(commercial, CommercialDTO.class);
//        }else {
//            return null;
//        }
//    }
//}
