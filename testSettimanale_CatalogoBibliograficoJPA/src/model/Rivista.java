package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Rivista.findAll", query = "SELECT r FROM Rivista r") //check
@Table (name = "Rivista")
public class Rivista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "isbn")
    private String isbn;
    
	@Column(name = "titolo")
    private String titolo;
    
	@Column(name = "anno")
    private int annoPubblicazione;
	
	@Column(name = "pagine")
    private int numPagine;
    
	@Enumerated(EnumType.STRING)
	@Column(name = "periodicita")
    private Periodicita periodicita;
	
    public Rivista() {

    }

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
    	this.isbn = isbn;
    	this.titolo = titolo;
    	this.annoPubblicazione = annoPubblicazione;
    	this.numPagine = numPagine;
        this.periodicita = periodicita;
    }

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}


}
