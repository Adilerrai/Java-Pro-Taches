package visite.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import visite.project.dto.GrossisteDTO;
import visite.project.service.GrossisteService;

@RestController
@RequestMapping("/api/grossiste")
public class GrossisteController {
    private final GrossisteService grossisteService;
    public GrossisteController(GrossisteService grossisteService) {
        this.grossisteService = grossisteService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GrossisteDTO> save(@RequestBody GrossisteDTO grossisteDTO) {
        GrossisteDTO grossiste = grossisteService.create(grossisteDTO);
        System.out.println("Grossiste saved successfully"+ grossiste);
        return ResponseEntity.ok(grossiste);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GrossisteDTO> find(@PathVariable Long id) {
        GrossisteDTO grossiste = grossisteService.findById(id);
        System.out.println("Grossiste found successfully"+ grossiste);
        return ResponseEntity.ok(grossiste);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GrossisteDTO> update(@RequestBody GrossisteDTO grossisteDTO) {
        GrossisteDTO grossiste = grossisteService.update(grossisteDTO);
        System.out.println("Grossiste updated successfully"+ grossiste);
        return ResponseEntity.ok(grossiste);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        grossisteService.delete(id);
        System.out.println("Grossiste deleted successfully");
        return ResponseEntity.ok("Grossiste deleted successfully");
    }


    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(grossisteService.findAll());
    }

}
