package com.example.EPIC.ENERGY.SERVICES.controller;

import java.util.List;
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

import com.example.EPIC.ENERGY.SERVICES.model.Ruolo;
import com.example.EPIC.ENERGY.SERVICES.service.RuoloService;

@RestController
@RequestMapping("/api/ruoli")
public class RuoloController {

    @Autowired
    private RuoloService ruoloService;

    @GetMapping
    public ResponseEntity<List<Ruolo>> getRuoli() {
        List<Ruolo> ruoli = ruoloService.getRuoli();
        return new ResponseEntity<>(ruoli, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Ruolo> createRuolo(@RequestBody Ruolo ruolo) {
        Ruolo createdRuolo = ruoloService.createRuolo(ruolo);
        return new ResponseEntity<>(createdRuolo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ruolo> updateRuolo(@PathVariable Long id, @RequestBody Ruolo ruolo) {
        Ruolo updatedRuolo = ruoloService.updateRuolo(id, ruolo);
        return new ResponseEntity<>(updatedRuolo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuolo(@PathVariable Long id) {
        ruoloService.deleteRuolo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
