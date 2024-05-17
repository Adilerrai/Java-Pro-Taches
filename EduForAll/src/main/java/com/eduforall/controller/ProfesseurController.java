package com.eduforall.controller;

import com.eduforall.dto.ProfesseurDTO;
import com.eduforall.model.Professeur;
import com.eduforall.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeur")
public class ProfesseurController {


    @Autowired
    private ProfesseurService professeurService;

    @GetMapping("/all")
    public ResponseEntity<List<ProfesseurDTO>> getAllProfesseurs() {

        return ResponseEntity.ok(professeurService.getAll());
    }


    @PostMapping("/save")
    public ResponseEntity<ProfesseurDTO> saveProfesseur(@RequestBody ProfesseurDTO professeurDTO) {

        return ResponseEntity.ok(professeurService.save(professeurDTO));
    }



    @PostMapping("/update")
    public ResponseEntity<ProfesseurDTO> updateProfesseur(@RequestBody ProfesseurDTO professeurDTO) {

        return ResponseEntity.ok(professeurService.update(professeurDTO));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ProfesseurDTO> getProfesseurById(@PathVariable Long id) {

        return ResponseEntity.ok(professeurService.getById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long id) {
        professeurService.delete(id);
        return ResponseEntity.ok().build();
    }



}
