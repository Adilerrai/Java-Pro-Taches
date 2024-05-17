package com.eduforall.controller;

import com.eduforall.dto.EleveDTO;
import com.eduforall.service.EleveService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eleve")
public class EleveController {

     @Autowired
     private EleveService eleveService;

     @GetMapping("/all")
        public ResponseEntity<List<EleveDTO>> getAllEleves(){
            return ResponseEntity.ok(eleveService.getAll());
        }


      @PostMapping("/save")
        public ResponseEntity<EleveDTO> saveEleve(@RequestBody EleveDTO eleveDTO){
            return ResponseEntity.ok(eleveService.save(eleveDTO));
        }

        @PostMapping("/update")
        public ResponseEntity<EleveDTO> updateEleve(@RequestBody EleveDTO eleveDTO){
            return ResponseEntity.ok(eleveService.update(eleveDTO));
        }

        @PostMapping("/delete/{id}")
        public ResponseEntity<String> deleteEleve(@PathVariable Long id){
            eleveService.delete(id);
            return ResponseEntity.ok("Eleve deleted");

        }

        @GetMapping("/get/{id}")
        public ResponseEntity<EleveDTO> getEleve(@PathVariable Long id){
            return ResponseEntity.ok(eleveService.getById(id));
        }
}
