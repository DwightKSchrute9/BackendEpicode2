package com.example.gestioneprenotazioni.runner;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gestioneprenotazioni.service.PrenotazioneService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PrenotaPostazione implements CommandLineRunner {
	
	private PrenotazioneService prenotazioneService;
	
	public PrenotaPostazione(PrenotazioneService prenotazioneService) {
		this.prenotazioneService = prenotazioneService;
	}

	@Override
	public void run(String... args) throws Exception {
		// leggi la mail, il codice della postazione e la data della prenotazione
		String email = args[3];
		String codice = args[4];
		String giorno = args[5];
		String mese = args[6];
		String anno = args[7];
		
		LocalDate dataPrenotazione = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
		
		prenotazioneService.prenota(email, codice, dataPrenotazione);
		// output OK con println o qualcosa del genere
	}

}
