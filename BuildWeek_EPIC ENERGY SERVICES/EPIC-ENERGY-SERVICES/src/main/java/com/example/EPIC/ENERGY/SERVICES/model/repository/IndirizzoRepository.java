package com.example.EPIC.ENERGY.SERVICES.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EPIC.ENERGY.SERVICES.model.Cliente;
import com.example.EPIC.ENERGY.SERVICES.model.Indirizzo;
import com.example.EPIC.ENERGY.SERVICES.model.Provincia;


public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long> {

    @Query("SELECT i.cliente FROM Indirizzo i WHERE i.citta LIKE %:parteNome% OR i.cap LIKE %:parteNome% OR i.via LIKE %:parteNome% OR i.provincia.nome LIKE %:parteNome%")
    List<Cliente> findByParteNome(String parteNome);

    @Query("SELECT i.cliente FROM Indirizzo i WHERE i.provincia = :provincia")
    List<Cliente> findByProvincia(Provincia provincia);

    @Query("SELECT i.cliente FROM Indirizzo i WHERE i.cliente.dataInserimento BETWEEN :dataInizio AND :dataFine")
    List<Cliente> findByDataInserimentoCliente(LocalDate dataInizio, LocalDate dataFine);

    @Query("SELECT i.cliente FROM Indirizzo i WHERE i.cliente.dataUltimoContatto BETWEEN :dataInizio AND :dataFine")
    List<Cliente> findByDataUltimoContattoCliente(LocalDate dataInizio, LocalDate dataFine);

    @Query("SELECT i.cliente FROM Indirizzo i ORDER BY i.cliente.nome")
    List<Cliente> findAllOrderedByNomeCliente();

    @Query("SELECT i.cliente FROM Indirizzo i ORDER BY i.cliente.dataInserimento")
    List<Cliente> findAllOrderedByDataInserimentoCliente();

    @Query("SELECT i.cliente FROM Indirizzo i ORDER BY i.cliente.dataUltimoContatto")
    List<Cliente> findAllOrderedByDataUltimoContattoCliente();

	List<Indirizzo> findByComuneNomeContainingIgnoreCase(String comune);

}
