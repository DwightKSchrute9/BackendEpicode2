package com.example.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.StatoFattura;
import com.example.EPIC.ENERGY.SERVICES.model.repository.StatoFatturaRepository;

@Service
public class StatoFatturaService {

    @Autowired
    private StatoFatturaRepository statoFatturaRepository;

    public List<StatoFattura> getAllStatiFattura() {
        return statoFatturaRepository.findAll();
    }

    public Optional<StatoFattura> getStatoFatturaById(Long id) {
        return statoFatturaRepository.findById(id);
    }

    public StatoFattura saveOrUpdateStatoFattura(StatoFattura statoFattura) {
        return statoFatturaRepository.save(statoFattura);
    }

    public void deleteStatoFatturaById(Long id) {
        statoFatturaRepository.deleteById(id);
    }

	public StatoFattura createStatoFattura(StatoFattura statoFattura) {
		// TODO Auto-generated method stub
		return null;
	}

	public StatoFattura updateStatoFattura(Long statoFatturaId, StatoFattura statoFatturaDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteStatoFattura(Long statoFatturaId) {
		// TODO Auto-generated method stub
		
	}

}
