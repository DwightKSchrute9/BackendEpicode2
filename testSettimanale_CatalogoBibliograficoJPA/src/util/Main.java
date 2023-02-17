
package com.example.library;

import com.example.library.dao.CatalogoItemDao;
import com.example.library.dao.LibroDao;
import com.example.library.dao.RivistaDao;
import com.example.library.dao.UtenteDao;
import com.example.library.dao.PrestitoDao;
import com.example.library.entities.Libro;
import com.example.library.entities.Rivista;
import com.example.library.entities.Utente;
import com.example.library.entities.Prestito;
import com.example.library.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        CatalogoItemDao catalogoItemDao = new CatalogoItemDao(entityManager);
        LibroDao libroDao = new LibroDao(entityManager);
        RivistaDao rivistaDao = new RivistaDao(entityManager);
        UtenteDao utenteDao = new UtenteDao(entityManager);
        PrestitoDao prestitoDao = new PrestitoDao(entityManager);

        // Aggiunta di un elemento del catalogo
        Libro libro = new Libro("1234567890", "Il nome della rosa", "Umberto Eco", 1980, 500, "Romanzo storico");
        catalogoItemDao.create(libro);

        // Ricerca per ISBN
        CatalogoItem catalogoItem = catalogoItemDao.findByIsbn("1234567890");
        System.out.println(catalogoItem);

        // Aggiunta di un utente
        Utente utente = new Utente("Mario", "Rossi", LocalDate.of(1990, 4, 20), "001");
        utenteDao.create(utente);

        // Aggiunta di un prestito
        Prestito prestito = new Prestito(utente, libro, LocalDate.now(), LocalDate.now().plusDays(30));
        prestitoDao.create(prestito);

        // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
        System.out.println(prestitoDao.findActiveByNumeroTesseraUtente("001"));

        entityManager.close();
        JPAUtil.shutdown();
    }
}
