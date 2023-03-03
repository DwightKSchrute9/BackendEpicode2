package com.example.gestioneprenotazioni;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.gestioneprenotazioni.entity.Edificio;
import com.example.gestioneprenotazioni.entity.Postazione;
import com.example.gestioneprenotazioni.repository.EdificioRepository;
import com.example.gestioneprenotazioni.repository.PostazioneRepository;

@SpringBootApplication
public class GestionePrenotazioniApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PostazioneRepository postazioneRepository, EdificioRepository edificioRepository) {
		return (args) -> {
			Edificio edificio1 = new Edificio("Edificio 1", null, null);
			edificioRepository.save(edificio1);

			Edificio edificio2 = new Edificio("Edificio 2", null, null);
			edificioRepository.save(edificio2);

			Postazione postazione1 = new Postazione("Postazione 1", null, null, 0, edificio1);
			postazione1.setDescrizione("Postazione per lavorare in piedi");
			postazioneRepository.save(postazione1);

			Postazione postazione2 = new Postazione("Postazione 2", null, null, 0, edificio2);
			postazione2.setDescrizione("Postazione per lavorare seduti");
			postazioneRepository.save(postazione2);

			Postazione postazione3 = new Postazione("Postazione 3", null, null, 0, edificio1);
			postazione3.setDescrizione("Postazione per lavorare in piedi");
			postazioneRepository.save(postazione3);

			Postazione postazione4 = new Postazione("Postazione 4", null, null, 0, edificio2);
			postazione4.setDescrizione("Postazione per lavorare seduti");
			postazioneRepository.save(postazione4);

			System.out.println("Postazioni salvate nel database:");
			postazioneRepository.findAll().forEach(System.out::println);
		};
	}

}
