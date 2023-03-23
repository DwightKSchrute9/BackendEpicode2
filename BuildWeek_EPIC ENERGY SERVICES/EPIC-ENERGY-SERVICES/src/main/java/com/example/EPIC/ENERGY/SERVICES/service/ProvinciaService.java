package com.example.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Provincia;
import com.example.EPIC.ENERGY.SERVICES.model.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public List<Provincia> getAllProvince() {
        return provinciaRepository.findAll();
    }

    public Optional<Provincia> getProvinciaById(Long id) {
        return provinciaRepository.findById(id);
    }

    public Provincia saveOrUpdateProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public void deleteProvinciaById(Long id) {
        provinciaRepository.deleteById(id);
    }

}
