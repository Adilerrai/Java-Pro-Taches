package visite.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import visite.project.dto.CommercialDTO;
import visite.project.service.CommercialService;

@RestController
@RequestMapping("/api/commercial")
public class CommercialController {
    private final CommercialService commercialService;

    public CommercialController(CommercialService commercialService){
        this.commercialService=commercialService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<CommercialDTO> save(@RequestBody CommercialDTO commercialDTO){
        CommercialDTO commercialDTO1= commercialService.creat(commercialDTO);
        return ResponseEntity.ok(commercialDTO1);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<CommercialDTO> find(@PathVariable Long id){
        CommercialDTO commercialDTO= commercialService.findById(id);
        return ResponseEntity.ok(commercialDTO);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<String> delete(@PathVariable Long id){
        commercialService.delete(id);
        return ResponseEntity.ok("Commercial deleted successfully");
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<CommercialDTO> updateCommercial(@RequestBody CommercialDTO commercialDTO){
        CommercialDTO commDTO = commercialService.update(commercialDTO);
        return ResponseEntity.ok(commDTO);
    }

    @GetMapping("/findByMatricule/{matricule}")
    @PreAuthorize("hasRole(ADMIN)")
    public  ResponseEntity<CommercialDTO> findByMatricule(@PathVariable long matricule){
        CommercialDTO commDTO =  commercialService.findByMatricule(matricule);
        return ResponseEntity.ok(commDTO);
    }

}
