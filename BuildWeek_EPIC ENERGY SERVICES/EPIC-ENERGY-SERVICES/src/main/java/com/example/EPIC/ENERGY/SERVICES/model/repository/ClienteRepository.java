package com.example.EPIC.ENERGY.SERVICES.model.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EPIC.ENERGY.SERVICES.model.Cliente;
import com.example.EPIC.ENERGY.SERVICES.model.Provincia;
import com.example.EPIC.ENERGY.SERVICES.model.StatoFattura;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNomeContainingIgnoreCase(String parteNome);
    
    List<Cliente> findByFattureDataFatturaBetween(LocalDate dataInizio, LocalDate dataFine);
    
    List<Cliente> findByFattureStato(StatoFattura stato);
    
    List<Cliente> findByFattureAnno(Integer anno);
    
    List<Cliente> findByProvinciaSedeLegale(Provincia provincia);
    
    @Query("SELECT c FROM Cliente c JOIN c.fatture f WHERE f.dataFattura BETWEEN :dataInizio AND :dataFine AND f.stato = :stato AND f.importo >= :importoMin AND f.importo <= :importoMax")
    List<Cliente> findByFilters(LocalDate dataInizio, LocalDate dataFine, StatoFattura stato, BigDecimal importoMin, BigDecimal importoMax);
    
    @Query("SELECT c, SUM(f.importo) AS fatturato_annuale FROM Cliente c JOIN c.fatture f WHERE YEAR(f.dataFattura) = :anno GROUP BY c ORDER BY fatturato_annuale DESC")
    List<Object[]> findFatturatoAnnualeByAnno(Integer anno);
    
    @Query("SELECT c FROM Cliente c ORDER BY c.nome")
    List<Cliente> findAllOrderedByNome();
    
    @Query("SELECT c FROM Cliente c JOIN c.fatture f ORDER BY f.importo DESC")
    List<Cliente> findAllOrderedByFatturatoAnnuale();
    
    @Query("SELECT c FROM Cliente c ORDER BY c.dataInserimento")
    List<Cliente> findAllOrderedByDataInserimento();
    
    @Query("SELECT c FROM Cliente c ORDER BY c.dataUltimoContatto")
    List<Cliente> findAllOrderedByDataUltimoContatto();
    
}
