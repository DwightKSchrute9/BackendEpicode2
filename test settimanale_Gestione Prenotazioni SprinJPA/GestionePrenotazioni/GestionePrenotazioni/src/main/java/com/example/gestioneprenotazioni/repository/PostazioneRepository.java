package com.example.gestioneprenotazioni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestioneprenotazioni.entity.Postazione;
import com.example.gestioneprenotazioni.entity.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	@Query(value = "select p from Postazione p where p.tipo = :tipo and p.edificio.citta = :citta")
	List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta);
	
	Optional<Postazione> findByCodice(String codice);
}

