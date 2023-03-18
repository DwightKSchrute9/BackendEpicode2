package com.example.SistemaRilevamentoIncendi.patterns;

import com.example.SistemaRilevamentoIncendi.model.Sonda;

public class SondaProxy implements ISondaProxy {
	private Sonda sonda;

	public SondaProxy(Sonda sonda) { 
		this.sonda = sonda;
	}
	@Override
	public void setSmokeLevel(int smokeLevel) {
		sonda.setSmokeLevel(smokeLevel);

	}

	@Override
	public int getSmokeLevel() {
		return sonda.getSmokeLevel();
	}

}
