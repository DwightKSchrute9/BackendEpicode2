package com.example.gestioneprenotazioni.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.gestioneprenotazioni.entity.Postazione;
import com.example.gestioneprenotazioni.repository.PostazioneRepository;
import com.example.gestioneprenotazioni.repository.PrenotazioneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostazioneService {
	
	private PostazioneRepository postazioneRepo;
	private PrenotazioneRepository prenotazioneRepo;
	
	public boolean eDisponibile(String codice, LocalDate data) throws Exception {
		Postazione postazione = postazioneRepo.findByCodice(codice).orElseThrow(() -> new Exception("postazione non trovata"));
		
		return eDisponibile(postazione, data);
	}

	public boolean eDisponibile(Postazione postazione, LocalDate date) {
		return prenotazioneRepo.findByPostazioneAndDataPrenotazione(postazione, date).isEmpty();
	}
}
