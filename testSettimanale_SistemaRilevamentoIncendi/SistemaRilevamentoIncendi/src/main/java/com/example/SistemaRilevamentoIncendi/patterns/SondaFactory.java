package com.example.SistemaRilevamentoIncendi.patterns;

import com.example.SistemaRilevamentoIncendi.model.Sonda;

//Interfaccia per la creazione degli oggetti
public interface SondaFactory {
public Sonda createSonda(String tipoSonda);
}