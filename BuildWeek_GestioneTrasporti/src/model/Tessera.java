package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tessera {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String codice;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissione;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataScadenza;
    
    public Tessera() {}
    
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
    
}
