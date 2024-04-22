package visite.project.controller;

import io.swagger.models.Response;
import org.springframework.boot.LazyInitializationBeanFactoryPostProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import visite.project.dto.LaboratoireDTO;
import visite.project.model.Laboratoire;
import visite.project.service.LaboratoireService;

import java.util.List;

@RestController
@RequestMapping("/api/laboratoire")
class LaboratoireController {
    private final LaboratoireService laboratoireService;
    public LaboratoireController(LaboratoireService laboratoireService) {
        this.laboratoireService= laboratoireService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LaboratoireDTO>> findAllLabos(){
        List<LaboratoireDTO> listlabos = laboratoireService.findAll();
        return  ResponseEntity.ok(listlabos);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<LaboratoireDTO> createLabo(@RequestBody LaboratoireDTO laboratoireDTO){
        LaboratoireDTO laboratoireDTO1 = laboratoireService.create(laboratoireDTO);
        return ResponseEntity.ok(laboratoireDTO1);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<LaboratoireDTO> updateLabo(@RequestBody LaboratoireDTO  laboratoireDTO ){
        LaboratoireDTO labo = laboratoireService.update(laboratoireDTO);
        return ResponseEntity.ok(labo);
    }

    @GetMapping("/findbynom/{nom}")
    public ResponseEntity<LaboratoireDTO> findBynom(@RequestBody String nom ){
        LaboratoireDTO labo = laboratoireService.findByNom(nom);
        return  ResponseEntity.ok(labo);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<LaboratoireDTO>> findAll(){
        List<LaboratoireDTO> listLabo =  laboratoireService.findAll();
        return ResponseEntity.ok(listLabo);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        laboratoireService.delete(id);
        System.out.println("laboratoire deleted successfully");
        return ResponseEntity.ok("Laboratoire deleted successfully");
    }
}
