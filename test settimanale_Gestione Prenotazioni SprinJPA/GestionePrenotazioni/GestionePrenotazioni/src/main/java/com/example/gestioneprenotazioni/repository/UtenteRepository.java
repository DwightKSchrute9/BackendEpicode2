
package com.example.gestioneprenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestioneprenotazioni.entity.Utente;

@Repository
public interface UtenteRepository<Utente> extends JpaRepository<Utente, Long> {

}
