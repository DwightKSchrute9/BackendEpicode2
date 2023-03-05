package com.example.gestioneprenotazioni.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.gestioneprenotazioni.entity.Utente;
import com.example.gestioneprenotazioni.repository.PrenotazioneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtenteService {
	
	private PrenotazioneRepository prenotazioneRepo;

	public boolean puoPrenotare(Utente utente, LocalDate date) {
		return prenotazioneRepo.findByUtenteAndDataPrenotazione(utente, date).isEmpty();
	}
}
