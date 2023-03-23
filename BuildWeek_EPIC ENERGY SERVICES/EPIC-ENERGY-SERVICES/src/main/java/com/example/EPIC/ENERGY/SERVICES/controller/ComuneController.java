package com.example.EPIC.ENERGY.SERVICES.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.EPIC.ENERGY.SERVICES.model.Comune;
import com.example.EPIC.ENERGY.SERVICES.service.ComuneService;

@RestController
@RequestMapping("/api/comuni")
public class ComuneController {

    @Autowired
    private ComuneService comuneService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comune>> getComuneById(@PathVariable Long id) {
        Optional<Comune> comune = comuneService.getComuneById(id);
        if (comune != null) {
            return ResponseEntity.ok(comune);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Comune>> getAllComuni() {
        List<Comune> comuni = comuneService.getAllComuni();
        return ResponseEntity.ok(comuni);
    }

    @PostMapping("/")
    public ResponseEntity<Comune> createComune(@Validated @RequestBody Comune comune) {
        Comune savedComune = comuneService.saveOrUpdateComune(comune);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComune);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comune> updateComune(@PathVariable Long id, @Validated @RequestBody Comune comune) {
        Optional<Comune> existingComune = comuneService.getComuneById(id);
        if (existingComune != null) {
            comune.setId(id);
            Comune savedComune = comuneService.saveOrUpdateComune(comune);
            return ResponseEntity.ok(savedComune);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComune(@PathVariable Long id) {
        Optional<Comune> existingComune = comuneService.getComuneById(id);
        if (existingComune != null) {
            comuneService.deleteComune(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
