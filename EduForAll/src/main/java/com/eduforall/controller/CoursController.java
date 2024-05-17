package com.eduforall.controller;

import com.eduforall.dto.CoursDTO;
import com.eduforall.model.criteria.CoursCriteria;
import com.eduforall.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;


    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<CoursDTO>> getAllCours() {
        return ResponseEntity.ok(coursService.getAllCours());

    }

    @GetMapping("/search")
    public ResponseEntity<List<CoursDTO>> searchCours(@RequestBody CoursCriteria coursCriteria) {
        return ResponseEntity.ok(coursService.searchByCriteria(coursCriteria, null));
    }

    @PostMapping("/save")
    public ResponseEntity<CoursDTO> saveCours(@RequestBody CoursDTO coursDTO) {
        System.out.println("coursDTO = " + coursDTO);
        return ResponseEntity.ok(coursService.saveCours(coursDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<CoursDTO> updateCours(@RequestBody CoursDTO coursDTO) {
        return ResponseEntity.ok(coursService.updateCours(coursDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCours(@RequestBody CoursDTO coursDTO) {
        coursService.deleteCours(coursDTO.getId());
        return (ResponseEntity<String>) ResponseEntity.ok();
    }

}

