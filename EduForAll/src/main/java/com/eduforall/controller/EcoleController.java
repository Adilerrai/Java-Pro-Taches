package com.eduforall.controller;

import com.eduforall.dto.EcoleDTO;
import com.eduforall.model.criteria.EcoleCriteria;
import com.eduforall.service.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecole")
public class EcoleController {

    @Autowired
    private EcoleService ecoleService;


    @GetMapping("/all")
    public ResponseEntity<List<EcoleDTO>> getAllEcoles(){
        return ResponseEntity.ok(ecoleService.getAllEcole());
    }

    @PostMapping("/save")
    public ResponseEntity<EcoleDTO> saveEcole(@RequestBody EcoleDTO ecoleDTO){
        return ResponseEntity.ok(ecoleService.saveEcole(ecoleDTO));
    }

    @PostMapping("/update")
    public ResponseEntity<EcoleDTO> updateEcole(@RequestBody EcoleDTO ecoleDTO){
        return ResponseEntity.ok(ecoleService.updateEcole(ecoleDTO));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteEcole(@PathVariable Long id){
        ecoleService.deleteEcole(id);
        return ResponseEntity.ok("Ecole deleted");

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EcoleDTO> getEcole(@PathVariable Long id){
        return ResponseEntity.ok(ecoleService.getEcoleById(id));
    }


    @GetMapping("/search")
    public ResponseEntity<List<EcoleDTO>> searchEcole(@RequestBody EcoleCriteria criteria){
        return ResponseEntity.ok(ecoleService.searchByCriteria(criteria, null));
    }



}
