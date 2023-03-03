package com.example.gestioneprenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestioneprenotazioni.entity.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

}

