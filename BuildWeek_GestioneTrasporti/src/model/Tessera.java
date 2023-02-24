package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
  @NamedQuery(name = "findAllTessere", query = "SELECT t FROM Tessera t"),
  @NamedQuery(name = "findTesseraByCodice", query = "SELECT t FROM Tessera t WHERE t.codice = :codice")
})
public class Tessera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codice;

    private Date dataEmissione;

    private Date dataScadenza;

    public Tessera() {
      // Costruttore vuoto richiesto dalla libreria di persistenza
    }

    public Tessera(String codice, Date dataEmissione, Date dataScadenza) {
        this.codice = codice;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public double getSaldo() {
        // TODO: Implementare il metodo getSaldo()
        return 0;
    }

    public void aggiungiSaldo(double saldo) {
        // TODO: Implementare il metodo aggiungiSaldo()
    }
}
