package com.example.EPIC.ENERGY.SERVICES.service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Cliente;
import com.example.EPIC.ENERGY.SERVICES.model.Fattura;
import com.example.EPIC.ENERGY.SERVICES.model.StatoFattura;
import com.example.EPIC.ENERGY.SERVICES.model.repository.FatturaRepository;

@Service
public class FatturaService {
    
    private final FatturaRepository repository;

    public FatturaService(FatturaRepository repository) {
        this.repository = repository;
    }
    
    public List<Fattura> getAllFatture() {
        return repository.findAll();
    }
    
    public Fattura getFatturaById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }
    
    public Fattura saveFattura(Fattura fattura) {
        return repository.save(fattura);
    }
    
    public Fattura updateFattura(Long id, Fattura updatedFattura) {
        Fattura fattura = repository.findById(id).orElseThrow();
        
        fattura.setCliente(updatedFattura.getCliente());
        fattura.setDataFattura(updatedFattura.getDataFattura());
        fattura.setImporto(updatedFattura.getImporto());
        fattura.setStato(updatedFattura.getStato());
        
        return repository.save(fattura);
    }
    
    public void deleteFatturaById(Long id) {
        repository.deleteById(id);
    }
    
    public List<Fattura> getFattureByCliente(Cliente cliente) {
        return repository.findByCliente(cliente);
    }
    
    public List<Fattura> getFattureByStato(StatoFattura stato) {
        return repository.findByStato(stato);
    }
    
    public List<Fattura> getFattureByDataFatturaBetween(LocalDate dataInizio, LocalDate dataFine) {
        return repository.findByDataFatturaBetween(dataInizio, dataFine);
    }
    
    public List<Fattura> getFattureByAnno(Integer anno) {
        return repository.findByAnno(anno);
    }
    
    public List<Fattura> getFattureByImportoBetween(BigDecimal importoMin, BigDecimal importoMax) {
        return repository.findByImportoBetween(importoMin, importoMax);
    }
    
    public List<Fattura> getFattureByFilters(Cliente cliente, StatoFattura stato, LocalDate dataInizio, LocalDate dataFine, BigDecimal importoMin, BigDecimal importoMax) {
        return repository.findByFilters(cliente, stato, dataInizio, dataFine, importoMin, importoMax);
    }

}
