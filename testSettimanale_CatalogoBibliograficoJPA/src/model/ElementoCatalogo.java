package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

//@NamedQuery(name = "removeByIsbn", query = "DELETE Libro l WHERE l.isbn = :n")
//@NamedQuery(name = "getByIsbn", query = "SELECT el FROM ElementoLetterario el WHERE el.isbn = :n")
//@NamedQuery(name = "getByAutore", query = "SELECT l FROM Libro l WHERE l.autore = :a")
//@NamedQuery(name = "getByTitolo", query = "SELECT el FROM ElementoLetterario el WHERE el.titolo LIKE :a")
//@NamedQuery(name = "getByAnno", query = "SELECT el FROM ElementoLetterario el WHERE el.anno= :n")

public abstract class ElementoCatalogo {
    @Id
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numPagine;

    public ElementoCatalogo() {}

    public ElementoCatalogo(String isbn, String titolo, int annoPubblicazione, int numPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
	public String toString() {
		return "ElementoCatalogo [isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numPagine=" + numPagine + "]";
	}

	public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }
}
