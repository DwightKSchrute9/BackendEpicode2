package com.example.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Ruolo;
import com.example.EPIC.ENERGY.SERVICES.model.repository.RuoloRepository;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    public List<Ruolo> getAllRuoli() {
        return ruoloRepository.findAll();
    }

    public Optional<Ruolo> getRuoloById(Long id) {
        return ruoloRepository.findById(id);
    }

    public Ruolo saveOrUpdateRuolo(Ruolo ruolo) {
        return ruoloRepository.save(ruolo);
    }

    public void deleteRuoloById(Long id) {
        ruoloRepository.deleteById(id);
    }

	public List<Ruolo> getRuoli() {
		// TODO Auto-generated method stub
		return null;
	}

	public Ruolo createRuolo(Ruolo ruolo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ruolo updateRuolo(Long id, Ruolo ruolo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteRuolo(Long id) {
		// TODO Auto-generated method stub
		
	}

}
