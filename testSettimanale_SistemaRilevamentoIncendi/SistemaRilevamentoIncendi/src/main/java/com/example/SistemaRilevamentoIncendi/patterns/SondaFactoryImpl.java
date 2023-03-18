package com.example.SistemaRilevamentoIncendi.patterns;

import com.example.SistemaRilevamentoIncendi.model.Sonda;

//Implementazione della factory
public class SondaFactoryImpl implements SondaFactory {

// Metodo di creazione degli oggetti
public Sonda createSonda(String tipoSonda){
   if(tipoSonda == null){
      return null;
   }        
   if(tipoSonda.equalsIgnoreCase("temperatura")){
      return new SondaTemperatura(tipoSonda);
   } else if(tipoSonda.equalsIgnoreCase("fumo")){
      return new SondaFumo(tipoSonda);
   } else if(tipoSonda.equalsIgnoreCase("gas")){
      return new SondaGas(tipoSonda);
   }
   return null;
}
}