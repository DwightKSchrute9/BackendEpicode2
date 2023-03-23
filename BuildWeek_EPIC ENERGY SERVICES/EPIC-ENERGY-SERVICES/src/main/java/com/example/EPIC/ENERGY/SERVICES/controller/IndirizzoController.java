package com.example.EPIC.ENERGY.SERVICES.controller;

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

import com.example.EPIC.ENERGY.SERVICES.model.Indirizzo;
import com.example.EPIC.ENERGY.SERVICES.service.IndirizzoService;

@RestController
@RequestMapping("/indirizzi")
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Indirizzo>> getIndirizzoById(@PathVariable("id") Long id) {
        Optional<Indirizzo> indirizzo = indirizzoService.getIndirizzoById(id);
        return ResponseEntity.ok(indirizzo);
    }

    @PostMapping
    public ResponseEntity<Indirizzo> createIndirizzo(@Validated @RequestBody Indirizzo indirizzo) {
        Indirizzo newIndirizzo = indirizzoService.createIndirizzo(indirizzo);
        return new ResponseEntity<>(newIndirizzo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Indirizzo> updateIndirizzo(@PathVariable("id") Long id, @Validated @RequestBody Indirizzo indirizzo) {
        Indirizzo updatedIndirizzo = indirizzoService.updateIndirizzo(id, indirizzo);
        return new ResponseEntity<>(updatedIndirizzo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndirizzo(@PathVariable("id") Long id) {
        indirizzoService.deleteIndirizzo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
