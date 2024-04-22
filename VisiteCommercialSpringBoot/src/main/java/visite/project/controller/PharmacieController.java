package visite.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import visite.project.dto.PharmacieDTO;
import visite.project.service.PharmacieService;

@RestController
@RequestMapping("/api/pharmacie")
public class PharmacieController {

    private final PharmacieService pharmacieService;

    public  PharmacieController(PharmacieService pharmacieService){
        this.pharmacieService= pharmacieService;
    }

    @GetMapping("/findbynom/{nom}")
    public ResponseEntity<PharmacieDTO> findBynom(@PathVariable String nom ){
        PharmacieDTO pharma = pharmacieService.findByNom(nom);
        return  ResponseEntity.ok(pharma);
    }

    @PostMapping("/create")
    public ResponseEntity<PharmacieDTO> createPharma(@RequestBody PharmacieDTO pharmacieDTO){
        PharmacieDTO pharmacieDTO1 = pharmacieService.create(pharmacieDTO);
        return  ResponseEntity.ok(pharmacieDTO1);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<PharmacieDTO> updatePharma(@RequestBody PharmacieDTO pharmacieDTO){
        PharmacieDTO pharma = pharmacieService.update(pharmacieDTO);
        return ResponseEntity.ok(pharma);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<String> deletePharma(@PathVariable long id){
        pharmacieService.delete(id);
        return  ResponseEntity.ok("deleted successfully");
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(pharmacieService.findAll());
    }

}
