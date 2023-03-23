package com.example.EPIC.ENERGY.SERVICES.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.example.EPIC.ENERGY.SERVICES.exception.ResourceNotFoundException;
import com.example.EPIC.ENERGY.SERVICES.model.StatoFattura;
import com.example.EPIC.ENERGY.SERVICES.service.StatoFatturaService;

@RestController
@RequestMapping("/api/stati-fattura")
public class StatoFatturaController {

    @Autowired
    private StatoFatturaService statoFatturaService;

    @GetMapping("")
    public List<StatoFattura> getAllStatiFattura() {
        return statoFatturaService.getAllStatiFattura();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StatoFattura>> getStatoFatturaById(@PathVariable(value = "id") Long statoFatturaId)
            throws ResourceNotFoundException {
        Optional<StatoFattura> statoFattura = statoFatturaService.getStatoFatturaById(statoFatturaId);
        return ResponseEntity.ok().body(statoFattura);
    }

    @PostMapping("")
    public StatoFattura createStatoFattura(@Validated @RequestBody StatoFattura statoFattura) {
        return statoFatturaService.createStatoFattura(statoFattura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatoFattura> updateStatoFattura(@PathVariable(value = "id") Long statoFatturaId,
            @Validated @RequestBody StatoFattura statoFatturaDetails) throws ResourceNotFoundException {
        StatoFattura updatedStatoFattura = statoFatturaService.updateStatoFattura(statoFatturaId, statoFatturaDetails);
        return ResponseEntity.ok(updatedStatoFattura);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteStatoFattura(@PathVariable(value = "id") Long statoFatturaId)
            throws ResourceNotFoundException {
        statoFatturaService.deleteStatoFattura(statoFatturaId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
