package com.example.gestioneprenotazioni.runner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ListaPostazioniTest {
	
	@Autowired
	private ListaPostazioni listaPostazioni;

	@Test
	public void listaPostazioniEsistenti() {
		try {
			listaPostazioni.run(new String[] {"Albuquerque, NM", "PRIVATO"});
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void listaPostazioniNonEsistenti() {
		try {
			listaPostazioni.run(new String[] {"asdasds", "PRIVATO"});
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void listaPostazioniErrore() {
		try {
			listaPostazioni.run(new String[] {"Albuquerque, NM", "ASDASDASODIAHSDOASIDH"});
			fail();
		} catch (Exception e) {
			assertEquals("tipo non valido: ASDASDASODIAHSDOASIDH", e.getMessage());
		}
	}
}
