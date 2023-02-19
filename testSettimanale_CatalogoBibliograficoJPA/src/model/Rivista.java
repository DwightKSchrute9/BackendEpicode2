package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Rivista")
public class Rivista extends ElementoCatalogo {
	
    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;

    private Periodicita periodicita;

    public Rivista() {
        super();
    }

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
    public Catalogo getCatalogo() {
        return catalogo;
    }

    @Override
	public String toString() {
		return "Rivista [catalogo=" + catalogo + ", periodicita=" + periodicita + "]";
	}

	public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

}
