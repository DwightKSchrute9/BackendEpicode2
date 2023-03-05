package com.example.gestioneprenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.gestioneprenotazioni.entity.Edificio;
import com.example.gestioneprenotazioni.entity.Postazione;
import com.example.gestioneprenotazioni.entity.TipoPostazione;
import com.example.gestioneprenotazioni.entity.Utente;
import com.example.gestioneprenotazioni.repository.EdificioRepository;
import com.example.gestioneprenotazioni.repository.UtenteRepository;

@SpringBootApplication
public class GestionePrenotazioniApplication {
	public static void main(String[] args) {
        SpringApplication.run(GestionePrenotazioniApplication.class, args);
    }
}

/*
@SpringBootApplication
@EnableAutoConfiguration
public class GestionePrenotazioniApplication implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionePrenotazioniApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Creazione edificio
        Edificio edificio = new Edificio("Green Hill", "3828 Piermont Dr NE", "Albuquerque, NM");
        edificioRepository.save(edificio);

        // Creazione postazioni
        Postazione postazione1 = new Postazione("123456", "Blabla", TipoPostazione.PRIVATO, 1, edificio);
        Postazione postazione2 = new Postazione("456789", "Blabla", TipoPostazione.OPENSPACE, 4, edificio);
        Postazione postazione3 = new Postazione("123654", "Blabla", TipoPostazione.SALA_RIUNIONI, 10, edificio);
        edificio.getPostazioni().add(postazione1);
        edificio.getPostazioni().add(postazione2);
        edificio.getPostazioni().add(postazione3);
        edificioRepository.save(edificio);

        // Creazione utenti
        Utente utente1 = new Utente("Mario", "Rossi", "mario.rossi@example.com");
        Utente utente2 = new Utente("Luigi", "Bianchi", "luigi.bianchi@example.com");
        utenteRepository.save(utente1);
        utenteRepository.save(utente2);
    }
}
*/
