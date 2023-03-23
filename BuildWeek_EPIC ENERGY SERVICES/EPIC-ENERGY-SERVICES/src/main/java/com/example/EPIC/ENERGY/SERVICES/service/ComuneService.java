package com.example.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Comune;
import com.example.EPIC.ENERGY.SERVICES.model.repository.ComuneRepository;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;

    public List<Comune> getAllComuni() {
        return comuneRepository.findAll();
    }

    public Optional<Comune> getComuneById(Long id) {
        return comuneRepository.findById(id);
    }

    public Comune saveOrUpdateComune(Comune comune) {
        return comuneRepository.save(comune);
    }

    public void deleteComuneById(Long id) {
        comuneRepository.deleteById(id);
    }

	public void deleteComune(Long id) {
		// TODO Auto-generated method stub
		
	}

}
