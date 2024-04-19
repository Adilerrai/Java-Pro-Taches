package visite.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import visite.project.dto.GrossisteDTO;
import visite.project.model.Grossiste;
import visite.project.service.GrossisteService;

@RestController
@RequestMapping("/api/grossiste")
public class GrossisteController {
    private final GrossisteService grossisteService;
    public GrossisteController(GrossisteService grossisteService) {
        this.grossisteService = grossisteService;
    }

    @PostMapping("/save")
    public ResponseEntity<GrossisteDTO> save(GrossisteDTO grossisteDTO) {
        GrossisteDTO grossiste = grossisteService.create(grossisteDTO);
        return ResponseEntity.ok(grossiste);
    }
}
