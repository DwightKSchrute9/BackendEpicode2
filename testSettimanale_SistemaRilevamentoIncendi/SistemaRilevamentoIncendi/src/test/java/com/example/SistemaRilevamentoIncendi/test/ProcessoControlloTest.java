package com.example.SistemaRilevamentoIncendi.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.SistemaRilevamentoIncendi.controllo.ProcessoControllo;
import com.example.SistemaRilevamentoIncendi.model.Sonda;


public class ProcessoControlloTest {
    
    @Test
    public void testAggiungiSonda() {
        ProcessoControllo processo = new ProcessoControllo(null);
        Sonda sonda = new Sonda("1");
        processo.aggiungiSonda(sonda);
        List<Sonda> elencoSonde = new ArrayList<>();
        elencoSonde.add(sonda);
        assertEquals(elencoSonde, processo.getSonde());
    }
    
    private void assertEquals(List<Sonda> elencoSonde, Object sonde) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testRimuoviSonda() {
        ProcessoControllo processo = new ProcessoControllo(null);
        Sonda sonda = new Sonda("1");
        processo.aggiungiSonda(sonda);
        processo.rimuoviSonda(sonda);
        List<Sonda> elencoSonde = new ArrayList<>();
        assertEquals(elencoSonde, processo.getSonde());
    }
}