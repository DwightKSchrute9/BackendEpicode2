package com.example.EPIC.ENERGY.SERVICES.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fattura")
public class Fattura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anno;
    private LocalDate data;
    private BigDecimal importo;
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "stato_fattura_id")
    private StatoFattura statoFattura;

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getImporto() {
		return importo;
	}

	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Object getCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCliente(Object cliente2) {
		// TODO Auto-generated method stub
		
	}

	public Object getDataFattura() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStato() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataFattura(Object dataFattura) {
		// TODO Auto-generated method stub
		
	}

	public void setStato(Object stato) {
		// TODO Auto-generated method stub
		
	}

    // costruttori, getter e setter, metodi ausiliari
}
