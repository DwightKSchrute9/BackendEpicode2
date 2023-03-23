package com.example.EPIC.ENERGY.SERVICES.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EPIC.ENERGY.SERVICES.model.Fattura;
import com.example.EPIC.ENERGY.SERVICES.model.StatoFattura;

import java.time.LocalDate;
import java.util.List;

public interface StatoFatturaRepository extends JpaRepository<StatoFattura, Long> {

    List<StatoFattura> findByFattura(Fattura fattura);
    
    List<StatoFattura> findByDataBetween(LocalDate dataInizio, LocalDate dataFine);
    
}
