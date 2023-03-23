package com.example.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Cliente;
import com.example.EPIC.ENERGY.SERVICES.model.Indirizzo;
import com.example.EPIC.ENERGY.SERVICES.model.Provincia;
import com.example.EPIC.ENERGY.SERVICES.model.repository.IndirizzoRepository;

@Service
public class IndirizzoService {
    
    @Autowired
    private IndirizzoRepository indirizzoRepository;
    
    public List<Indirizzo> getAllIndirizzi() {
        return indirizzoRepository.findAll();
    }
    
    public Optional<Indirizzo> getIndirizzoById(Long id) {
        return indirizzoRepository.findById(id);
    }
    
    public List<Indirizzo> getIndirizziByComune(String comune) {
        return indirizzoRepository.findByComuneNomeContainingIgnoreCase(comune);
    }
    
    public List<Cliente> getIndirizziByProvincia(Provincia provincia) {
        return indirizzoRepository.findByProvincia(provincia);
    }
    
    public Indirizzo saveIndirizzo(Indirizzo indirizzo) {
        return indirizzoRepository.save(indirizzo);
    }
    
    public void deleteIndirizzo(Long id) {
        indirizzoRepository.deleteById(id);
    }

	public Indirizzo createIndirizzo(Indirizzo indirizzo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Indirizzo updateIndirizzo(Long id, Indirizzo indirizzo) {
		// TODO Auto-generated method stub
		return null;
	}
}
