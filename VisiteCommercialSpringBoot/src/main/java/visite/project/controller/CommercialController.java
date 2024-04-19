package visite.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import visite.project.dto.CommercialDTO;
import visite.project.service.CommercialService;
import visite.project.service.implementation.CommercialServiceImpl;

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
        return ResponseEntity.ok(commercialDTO);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<CommercialDTO> find(@PathVariable Long id){
        CommercialDTO commercialDTO= commercialService.findById(id);
        return ResponseEntity.ok(commercialDTO);
    }
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<String> delete(@PathVariable Long id){
        commercialService.delete(id);
        return ResponseEntity.ok("Commercial deleted successfully");
    }
}
