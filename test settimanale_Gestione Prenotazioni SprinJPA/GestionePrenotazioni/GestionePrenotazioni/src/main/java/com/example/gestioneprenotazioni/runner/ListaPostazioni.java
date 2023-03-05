package com.example.gestioneprenotazioni.runner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gestioneprenotazioni.entity.Postazione;
import com.example.gestioneprenotazioni.entity.TipoPostazione;
import com.example.gestioneprenotazioni.repository.PostazioneRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListaPostazioni implements CommandLineRunner {
	
	private final PostazioneRepository postazioneRepo = null;
	
	@Override
	public void run(String... args) throws Exception {
		// leggi la città e il tipo dagli args
		String citta = args[0];
		String tipo = args[1];
		TipoPostazione tipoPostazione;
		
		switch(tipo) {
			case "PRIVATO": tipoPostazione = TipoPostazione.PRIVATO; break;
			case "OPENSPACE": tipoPostazione = TipoPostazione.OPENSPACE; break;
			case "SALA_RIUNIONI": tipoPostazione = TipoPostazione.SALA_RIUNIONI; break;
			default: throw new Exception("tipo non valido: " + tipo);
		}
		
		List<Postazione> postazioni = postazioneRepo.findByTipoAndCitta(tipoPostazione, citta);
		
		// stampa la lista delle postazioni trovate (con tutte le info su postazione e edificio)
		for (Postazione postazione : postazioni) {
			// stampa postazione (completa con tutti i dati!!)
			System.out.println("Codice postazione: " + postazione.getCodice());
			System.out.println("Descrizione postazione: " + postazione.getDescrizione());
			System.out.println("Tipo postazione: " + postazione.getTipo());
			System.out.println("Città postazione: " + postazione.getCitta());
			System.out.println("Edificio: " + postazione.getEdificio().getNome());
			System.out.println("Indirizzo edificio: " + postazione.getEdificio().getIndirizzo());
			System.out.println("Città edificio: " + postazione.getEdificio().getCitta());
			System.out.println("-----------------------------------------");
		}
	}
}

