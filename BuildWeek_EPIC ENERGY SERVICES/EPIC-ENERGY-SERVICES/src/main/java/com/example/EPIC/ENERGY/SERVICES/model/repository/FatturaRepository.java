package com.example.EPIC.ENERGY.SERVICES.model.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EPIC.ENERGY.SERVICES.model.Cliente;
import com.example.EPIC.ENERGY.SERVICES.model.Fattura;
import com.example.EPIC.ENERGY.SERVICES.model.StatoFattura;


public interface FatturaRepository extends JpaRepository<Fattura, Long> {
    
    List<Fattura> findByCliente(Cliente cliente);
    
    List<Fattura> findByStato(StatoFattura stato);
    
    List<Fattura> findByDataFatturaBetween(LocalDate dataInizio, LocalDate dataFine);
    
    List<Fattura> findByAnno(Integer anno);
    
    @Query("SELECT f FROM Fattura f WHERE f.importo >= :importoMin AND f.importo <= :importoMax")
    List<Fattura> findByImportoBetween(BigDecimal importoMin, BigDecimal importoMax);
    
}


