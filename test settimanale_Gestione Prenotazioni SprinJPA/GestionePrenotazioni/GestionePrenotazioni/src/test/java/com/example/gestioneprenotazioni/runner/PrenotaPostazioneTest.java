package com.example.gestioneprenotazioni.runner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrenotaPostazioneTest {
	
	@Autowired
	private PrenotaPostazione prenotaPostazione;

	@Test
	public void prenotaOk() {
		// utente esistente, postazione esistente, postazione disponibile, utente non ha altre postazioni
		try {
			prenotaPostazione.run("", "", "", "", ""); // completa parametri
			// controlla output
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void prenotaUtenteNonTrovato() {
		// fai girare con un utente non trovato
		try {
			prenotaPostazione.run("", "", "", "", ""); // completa parametri
			fail();
		} catch (Exception e) {
			assertEquals("utente non trovato", e.getMessage());
		}
	}
	
	@Test
	public void prenotaPostazioneNonTrovata() {
		// idem con patate ma modifichi i parametri e il messagio di errore
	}
	
	@Test
	public void prenotaPostazioneGiaPrenotata() {
		
	}
	
	@Test
	public void prenotaUtenteGiaPrenotato() {
		
	}
}

