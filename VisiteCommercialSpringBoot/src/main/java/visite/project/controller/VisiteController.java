package visite.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import visite.project.dto.VisiteDTO;
import visite.project.model.enums.Status;
import visite.project.service.VisiteService;

import java.util.List;

@RestController
@RequestMapping("/api/visite")
public class VisiteController {
    private final VisiteService visiteService;

    public VisiteController(VisiteService visiteService) {
        this.visiteService = visiteService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VisiteDTO> save(@RequestBody VisiteDTO visiteDTO) {
        VisiteDTO visite = visiteService.create(visiteDTO);
        System.out.println("Visite saved successfully" + visite);
        return ResponseEntity.ok(visite);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VisiteDTO> find(@PathVariable Long id) {
        VisiteDTO visite = visiteService.findById(id);
        System.out.println("Visite found successfully" + visite);
        return ResponseEntity.ok(visite);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VisiteDTO> update(@RequestBody VisiteDTO visiteDTO) {
        VisiteDTO visite = visiteService.update(visiteDTO);
        System.out.println("Visite updated successfully" + visite);
        return ResponseEntity.ok(visite);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        visiteService.delete(id);
        System.out.println("Visite deleted successfully");
        return ResponseEntity.ok("Visite deleted successfully");
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(visiteService.findAll());
    }


    @GetMapping("/allByCommercial/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<VisiteDTO>> findAllByCommercial(@PathVariable Long id) {
        return ResponseEntity.ok(visiteService.findByCommercialId(id));
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity updateStatus(@PathVariable Long id, @RequestParam String status) {
        if (!Status.contains(status)) {
            return ResponseEntity.badRequest().body("Invalid status");
        }
        visiteService.updateStatus(id, Status.valueOf(status));
        return ResponseEntity.ok("Status updated successfully");
    }

    @GetMapping("/allByLaboratoire/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<VisiteDTO>> findAllByLaboratoire(@PathVariable Long id) {
        return ResponseEntity.ok(visiteService.findByLaboratoireId(id));
    }
}
