package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l") //check
@Table (name = "Libro")
public class Libro  {
	
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
    
	@Column(name = "autore")
    private String autore;
	
	@Column(name = "genere")
    private String genere;

    public Libro() {}

    public Libro(String isbn, String titolo, int annoPubblicazione, int numPagine, String autore, String genere) {
    	this.isbn = isbn;
    	this.titolo = titolo;
    	this.annoPubblicazione = annoPubblicazione;
    	this.numPagine = numPagine;
        this.autore = autore;
        this.genere = genere;
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

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

}
