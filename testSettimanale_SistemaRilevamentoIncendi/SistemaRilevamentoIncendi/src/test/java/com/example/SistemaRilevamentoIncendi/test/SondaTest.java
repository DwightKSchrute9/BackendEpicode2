package com.example.SistemaRilevamentoIncendi.test;

import org.junit.jupiter.api.Test;

import com.example.SistemaRilevamentoIncendi.model.Sonda;

public class SondaTest {
    
    @Test
    public void testGetId() {
        Sonda sonda = new Sonda("1");
        assertEquals("1", sonda.getIdSonda());
    }
    
    private void assertEquals(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testGetFumo() {
        Sonda sonda = new Sonda("1");
        sonda.setFumo(5);
        assertEquals(5, sonda.getFumo());
    }

    private void assertEquals(int i, int fumo) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testSetFumo() {
        Sonda sonda = new Sonda("1");
        sonda.setFumo(5);
        assertEquals(5, sonda.getFumo());
    }
}