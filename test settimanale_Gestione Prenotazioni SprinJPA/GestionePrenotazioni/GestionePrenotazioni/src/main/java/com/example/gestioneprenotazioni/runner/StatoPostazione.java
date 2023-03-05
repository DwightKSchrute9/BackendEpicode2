package com.example.gestioneprenotazioni.runner;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gestioneprenotazioni.service.PostazioneService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StatoPostazione implements CommandLineRunner {
	
	private PostazioneService postazioneService;
	
	public StatoPostazione(PostazioneService postazioneService) {
		this.postazioneService = postazioneService;
	}

	@Override
	public void run(String... args) throws Exception {
		// Leggi la data e il codice della postazione dagli arg
		String codice = args[4];
		String giorno = args[5];
		String mese = args[6];
		String anno = args[7];
		
		LocalDate dataPrenotazione = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
		boolean disponibile = postazioneService.eDisponibile(codice, dataPrenotazione);
		
		// stampa LIBERA o OCCUPATA
		if (disponibile) {
			System.out.println("LIBERA");
		} else {
			System.out.println("OCCUPATA");
		}
	}

}

