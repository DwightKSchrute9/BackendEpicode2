package com.example.EPIC.ENERGY.SERVICES.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.EPIC.ENERGY.SERVICES.model.Fattura;
import com.example.EPIC.ENERGY.SERVICES.service.FatturaService;

@RestController
@RequestMapping("/api/fatture")
public class FatturaController {

    @Autowired
    private FatturaService fatturaService;

    @GetMapping("")
    public List<Fattura> getAllFatture() {
        return fatturaService.getAllFatture();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fattura> getFatturaById(@PathVariable Long id) {
        Fattura fattura = fatturaService.getFatturaById(id);
        return ResponseEntity.ok().body(fattura);
    }

    @PostMapping("")
    public ResponseEntity<Fattura> createFattura(@Validated @RequestBody Fattura fattura) {
        fattura = fatturaService.createFattura(fattura);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fattura.getId())
                .toUri();
        return ResponseEntity.created(location).body(fattura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fattura> updateFattura(@PathVariable Long id, @Validated @RequestBody Fattura fattura) {
        fattura.setId(id);
        fattura = fatturaService.updateFattura(fattura);
        return ResponseEntity.ok().body(fattura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFattura(@PathVariable Long id) {
        fatturaService.deleteFattura(id);
        return ResponseEntity.noContent().build();
    }
}
