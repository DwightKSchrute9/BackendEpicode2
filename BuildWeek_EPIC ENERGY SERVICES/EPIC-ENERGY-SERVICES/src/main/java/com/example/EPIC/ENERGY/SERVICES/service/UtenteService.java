package com.example.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Ruolo;
import com.example.EPIC.ENERGY.SERVICES.model.Utente;
import com.example.EPIC.ENERGY.SERVICES.model.repository.UtenteRepository;

@Service
@Transactional
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Optional<Utente> findById(Long id) {
        return utenteRepository.findById(id);
    }

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    public void deleteById(Long id) {
        utenteRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return utenteRepository.existsByUsername(username);
    }

    public Optional<Utente> findByUsername(String username) {
        return Optional.ofNullable(utenteRepository.findByUsername(username));
    }

    public List<Utente> findByRuolo(Ruolo ruolo) {
        return utenteRepository.findByRuolo(ruolo);
    }

    public List<Utente> findByNomeContainingIgnoreCase(String nome) {
        return utenteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Utente> findByCognomeContainingIgnoreCase(String cognome) {
        return utenteRepository.findByCognomeContainingIgnoreCase(cognome);
    }

    public List<Utente> findByEmailContainingIgnoreCase(String email) {
        return utenteRepository.findByEmailContainingIgnoreCase(email);
    }

    public List<Utente> findByNomeAndCognomeContainingIgnoreCase(String nome, String cognome) {
        return utenteRepository.findByNomeAndCognomeContainingIgnoreCase(nome, cognome);
    }

	public List<Utente> getAllUtenti() {
		// TODO Auto-generated method stub
		return null;
	}

	public Utente getUtenteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Utente createUtente(Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}

	public Utente updateUtente(Long id, Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUtente(Long id) {
		// TODO Auto-generated method stub
		
	}
}
