package model;


@Entity
class Rivista extends CatalogoItem {

    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

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

}
