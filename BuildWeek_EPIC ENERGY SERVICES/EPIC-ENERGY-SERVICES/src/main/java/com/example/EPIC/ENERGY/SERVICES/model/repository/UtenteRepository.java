package com.example.EPIC.ENERGY.SERVICES.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EPIC.ENERGY.SERVICES.model.Ruolo;
import com.example.EPIC.ENERGY.SERVICES.model.Utente;


public interface UtenteRepository extends JpaRepository<Utente, Long> {
    
    Utente findByEmail(String email);

	boolean existsByUsername(String username);

	Utente findByUsername(String username);

	List<Utente> findByRuolo(Ruolo ruolo);

	List<Utente> findByNomeContainingIgnoreCase(String nome);

	List<Utente> findByCognomeContainingIgnoreCase(String cognome);

	List<Utente> findByEmailContainingIgnoreCase(String email);

	List<Utente> findByNomeAndCognomeContainingIgnoreCase(String nome, String cognome);
    
}
