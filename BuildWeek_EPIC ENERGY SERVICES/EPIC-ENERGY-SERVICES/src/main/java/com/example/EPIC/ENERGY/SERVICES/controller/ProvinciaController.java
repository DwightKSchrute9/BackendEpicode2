package com.example.EPIC.ENERGY.SERVICES.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EPIC.ENERGY.SERVICES.model.Provincia;
import com.example.EPIC.ENERGY.SERVICES.service.ProvinciaService;

@RestController
@RequestMapping("/provincia")
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService provinciaService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Provincia>> getProvinciaById(@PathVariable("id") Long id) {
        Optional<Provincia> provincia = provinciaService.getProvinciaById(id);
        if (provincia != null) {
            return ResponseEntity.ok(provincia);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Provincia>> getAllProvince() {
        List<Provincia> province = provinciaService.getAllProvince();
        if (!province.isEmpty()) {
            return ResponseEntity.ok(province);
        }
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/")
    public ResponseEntity<Provincia> addProvincia(@RequestBody Provincia provincia) {
        Provincia newProvincia = provinciaService.addProvincia(provincia);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProvincia);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Provincia> updateProvincia(@PathVariable("id") Long id, @RequestBody Provincia provincia) {
        provincia.setId(id);
        Provincia updatedProvincia = provinciaService.updateProvincia(provincia);
        if (updatedProvincia != null) {
            return ResponseEntity.ok(updatedProvincia);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvincia(@PathVariable("id") Long id) {
        boolean deleted = provinciaService.deleteProvincia(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
