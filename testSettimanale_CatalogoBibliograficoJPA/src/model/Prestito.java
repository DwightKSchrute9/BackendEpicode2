package model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

//@NamedQuery (name = "prestitoBytessera", query = "SELECT p FROM Prestito p where p.utente.numeroTessera = :nt")
//@NamedQuery (name = "prestitiScaduti", query = "SELECT p FROM Prestito p WHERE (dataRestituzionePrev > CURRENT DATE AND dataRestituzioneEff IS NULL)")
public class Prestito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private Utente utente;
    
    @ManyToOne
    @JoinColumn(name = "catalogoItem_id")
    private ElementoCatalogo catalogoItem;
    
    @Temporal(TemporalType.DATE)
    private Date dataInizioPrestito;
    
    @Temporal(TemporalType.DATE)
    private Date dataRestituzionePrevista;
    
    @Temporal(TemporalType.DATE)
    private Date dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, ElementoCatalogo catalogoItem, Date dataInizioPrestito) {
        this.utente = utente;
        this.catalogoItem = catalogoItem;
        this.dataInizioPrestito = dataInizioPrestito;
        Calendar c = Calendar.getInstance();
        c.setTime(dataInizioPrestito);
        c.add(Calendar.DATE, 30);
        this.dataRestituzionePrevista = c.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoCatalogo getCatalogoItem() {
        return catalogoItem;
    }

    public void setCatalogoItem(ElementoCatalogo catalogoItem) {
        this.catalogoItem = catalogoItem;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public boolean isRestituito() {
        return this.dataRestituzioneEffettiva != null;
    }

    public boolean isScaduto() {
        Date oggi = new Date();
        return oggi.after(this.dataRestituzionePrevista) && !this.isRestituito();
    }
}
