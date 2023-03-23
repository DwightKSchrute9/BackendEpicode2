package com.example.EPIC.ENERGY.SERVICES.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EPIC.ENERGY.SERVICES.model.Provincia;


public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    
    Provincia findByNomeIgnoreCase(String nome);
    
}
