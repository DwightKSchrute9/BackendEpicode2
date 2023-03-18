package com.example.SistemaRilevamentoIncendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SistemaRilevamentoIncendi.model.Sonda;
import com.example.SistemaRilevamentoIncendi.patterns.SondaFactory;
import com.example.SistemaRilevamentoIncendi.patterns.SondaFactoryImpl;

@SpringBootApplication
public class SistemaRilevamentoIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaRilevamentoIncendiApplication.class, args);
		
	      SondaFactory sondaFactory = new SondaFactoryImpl();
	      
	      // Creazione di una sonda di temperatura
	      Sonda sondaTemperatura = sondaFactory.createSonda("temperatura");
	      sondaTemperatura.installaSonda();
	      
	      // Creazione di una sonda di fumo
	      Sonda sondaFumo = sondaFactory.createSonda("fumo");
	      sondaFumo.installaSonda();
	      
	      // Creazione di una sonda di gas
	      Sonda sondaGas = sondaFactory.createSonda("gas");
	      sondaGas.installaSonda();
	}

}

	