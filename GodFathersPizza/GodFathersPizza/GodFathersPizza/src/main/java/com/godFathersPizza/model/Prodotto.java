package com.godFathersPizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public abstract class Prodotto {
	
	String nome;
	double prezzo; 
	
	public Prodotto(String nome2, double prezzo2) {
		// TODO Auto-generated constructor stub
	}
	
	

}
