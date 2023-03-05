package com.example.gestioneprenotazioni.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.gestioneprenotazioni.entity.Postazione;
import com.example.gestioneprenotazioni.entity.Prenotazione;
import com.example.gestioneprenotazioni.entity.Utente;
import com.example.gestioneprenotazioni.repository.PostazioneRepository;
import com.example.gestioneprenotazioni.repository.PrenotazioneRepository;
import com.example.gestioneprenotazioni.repository.UtenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {

	private PrenotazioneRepository prenotazioneRepo;
	
	private PostazioneService postazioneService;
	
	private UtenteService utenteService;
	
	private UtenteRepository utenteRepo;
	
	private PostazioneRepository postazioneRepo;
	
	public Prenotazione prenota(String email, String codicePostazione, LocalDate data) throws Exception {
		Utente utente = utenteRepo.findByEmail(email).orElseThrow(() -> new Exception("utente non trovato"));
		Postazione postazione = postazioneRepo.findByCodice(codicePostazione).orElseThrow(() -> new Exception("postazione non trovata"));
		
		return prenota(utente, postazione, data);
	}

	public Prenotazione prenota(Utente utente, Postazione postazione, LocalDate data) throws Exception {
		if (!utenteService.puoPrenotare(utente, data)) {
			throw new Exception("l'utente ha già prenotato una postazione per questo giorno");
		}
		
		if (!postazioneService.eDisponibile(postazione, data)) {
			throw new Exception("la postazione non è disponibile per questo giorno");
		}
		
		Prenotazione prenotazione = new Prenotazione(data, postazione, utente);
		return prenotazioneRepo.save(prenotazione);
	}
}
