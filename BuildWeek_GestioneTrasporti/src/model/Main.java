package model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        testAddDistributoreAutomatico();
        testGetDistributoreAutomatico();
        testRemoveDistributoreAutomatico();
        testGetDistributoriAutomatici();
    }
    
    private static void testGetDistributoriAutomatici() {
		// TODO Auto-generated method stub
		
	}

	private static void testAddDistributoreAutomatico() {
        DistributoreAutomatico d1 = new DistributoreAutomatico("D1", "Via Roma 1", false);
        DistributoreAutomatico d2 = new DistributoreAutomatico("D2", "Via Milano 2", false);
        DistributoreAutomatico d3 = new DistributoreAutomatico("D3", "Via Torino 3", false);
        
        List<DistributoreAutomatico> distributori = new ArrayList<>();
        
        // Aggiunta di un distributore automatico alla lista
        distributori.add(d1);
        
        // Aggiunta di un altro distributore automatico alla lista
        distributori.add(d2);
        
        // Aggiunta di un altro distributore automatico alla lista
        distributori.add(d3);
        
        // Verifica che il primo elemento della lista sia d1
        assert distributori.get(0).equals(d1);
        
        // Verifica che la lista contenga esattamente 3 elementi
        assert distributori.size() == 3;
    }
    
    private static void testGetDistributoreAutomatico() {
        DistributoreAutomatico d1 = new DistributoreAutomatico("D1", "Via Roma 1", false);
        DistributoreAutomatico d2 = new DistributoreAutomatico("D2", "Via Milano 2", false);
        DistributoreAutomatico d3 = new DistributoreAutomatico("D3", "Via Torino 3", false);
        
        List<DistributoreAutomatico> distributori = new ArrayList<>();
        
        distributori.add(d1);
        distributori.add(d2);
        distributori.add(d3);
        
        // Verifica che il distributore automatico con id "D1" sia d1
        assert DistributoreAutomatico.getDistributoreAutomatico("D1", distributori).equals(d1);
        
        // Verifica che il distributore automatico con id "D4" non sia presente nella lista
        assert DistributoreAutomatico.getDistributoreAutomatico("D4", distributori) == null;
    }
    
    private static void testRemoveDistributoreAutomatico() {
        DistributoreAutomatico d1 = new DistributoreAutomatico("D1", "Via Roma 1", false);
        DistributoreAutomatico d2 = new DistributoreAutomatico("D2", "Via Milano 2", false);
        DistributoreAutomatico d3 = new DistributoreAutomatico("D3", "Via Torino 3", false);
        
        List<DistributoreAutomatico> distributori = new ArrayList<>();
        
        distributori.add(d1);
        distributori.add(d2);
        distributori.add(d3);
        
        // Rimozione del distributore automatico con id "D2"
        DistributoreAutomatico.getDistributoreAutomatico("D2", distributori);
        
        // Verifica che la lista contenga esattamente 2 elementi
       // assert distributori.size()
    }
}

