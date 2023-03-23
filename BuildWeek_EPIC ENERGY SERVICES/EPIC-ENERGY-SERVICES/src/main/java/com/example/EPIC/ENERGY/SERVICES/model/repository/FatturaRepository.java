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
    
    List<Fattura> findByDataFattura(LocalDate dataFattura);
    
    List<Fattura> findByAnno(Integer anno);
    
    List<Fattura> findByImportoBetween(BigDecimal importoMin, BigDecimal importoMax);
    
    @Query("SELECT f FROM Fattura f WHERE f.cliente = :cliente AND f.dataFattura BETWEEN :dataInizio AND :dataFine AND f.stato = :stato AND f.importo >= :importoMin AND f.importo <= :importoMax")
    List<Fattura> findByFilters(Cliente cliente, LocalDate dataInizio, LocalDate dataFine, StatoFattura stato, BigDecimal importoMin, BigDecimal importoMax);

	List<Fattura> findByDataFatturaBetween(LocalDate dataInizio, LocalDate dataFine);

	List<Fattura> findByFilters(Cliente cliente, StatoFattura stato, LocalDate dataInizio, LocalDate dataFine,
			BigDecimal importoMin, BigDecimal importoMax);
    
}

