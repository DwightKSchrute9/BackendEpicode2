package com.example.SistemaRilevamentoIncendi.controllo;

import java.util.ArrayList;
import java.util.List;

import com.example.SistemaRilevamentoIncendi.model.Allarme;
import com.example.SistemaRilevamentoIncendi.model.Sonda;
import com.example.SistemaRilevamentoIncendi.patterns.Observable;
import com.example.SistemaRilevamentoIncendi.patterns.Observer;

public class ProcessoControllo implements Observer {
    private List<Sonda> sonde = new ArrayList<>();

    public ProcessoControllo(Object object) {
		// TODO Auto-generated constructor stub
	}

	public void addSonda(Sonda sonda) {
        sonde.add(sonda);
        sonda.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        Sonda sonda = (Sonda) observable;
        String message = "Allarme " + sonda.getIdSonda() + ": fumo rilevato (" + sonda.getSmokeLevel() + ")";
        System.out.println(message);
    }



	public void aggiungiSonda(Sonda sonda2) {
		// TODO Auto-generated method stub
		
	}

	public Object getSonde() {
		// TODO Auto-generated method stub
		return null;
	}

	public void rimuoviSonda(Sonda sonda2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable observable) {
		// TODO Auto-generated method stub
		
	}
}