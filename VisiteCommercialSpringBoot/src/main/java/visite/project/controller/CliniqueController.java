package visite.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import visite.project.dto.CliniqueDTO;
import visite.project.model.Clinique;
import visite.project.service.CliniqueService;

@RestController
@RequestMapping("/api/clinique")
public class CliniqueController  {

    private final CliniqueService cliniqueService;
    public CliniqueController(CliniqueService cliniqueService) {
        this.cliniqueService = cliniqueService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<CliniqueDTO> createClinique(@RequestBody CliniqueDTO cliniqueDTO){
        CliniqueDTO cliniqueDTO1 = cliniqueService.save(cliniqueDTO);
        return ResponseEntity.ok(cliniqueDTO1);
    }

    @GetMapping("/findbynom/{nom}")
    public ResponseEntity<CliniqueDTO> getClinique(@PathVariable String nom){
        CliniqueDTO cliniqueDTO = cliniqueService.findByNom(nom);
        return ResponseEntity.ok(cliniqueDTO);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<CliniqueDTO> updateClinique(@RequestBody CliniqueDTO cliniqueDTO){
        CliniqueDTO  cliniqueDTO1 = cliniqueService.update(cliniqueDTO);
        return  ResponseEntity.ok(cliniqueDTO1);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<String> deleteClinique(@PathVariable long id){
        cliniqueService.delete(id);
        return ResponseEntity.ok("Deletion complete successfuly ");
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(cliniqueService.findAll());
    }
}
