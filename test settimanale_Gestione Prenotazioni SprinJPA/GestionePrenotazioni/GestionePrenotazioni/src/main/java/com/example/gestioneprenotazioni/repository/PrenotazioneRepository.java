package com.example.gestioneprenotazioni.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestioneprenotazioni.entity.Postazione;
import com.example.gestioneprenotazioni.entity.Prenotazione;
import com.example.gestioneprenotazioni.entity.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
	
	Optional<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}
