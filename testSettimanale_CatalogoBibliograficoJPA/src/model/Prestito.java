package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@NamedQuery(name = "Prestito.findAll", query = "SELECT p FROM Prestito p")
@Table (name = "Prestito")
public class Prestito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "utente")
    private Utente utente;
    
    @ManyToOne
    @JoinColumn(name = "libro")
    private Libro libro;
    
    @ManyToOne
    @JoinColumn(name = "rivista")
    private Rivista rivista;
    
    @Column(name = "inizio_prestito")
    private String dataInizioPrestito;
    
    @Column(name = "rest_prevista")
    private String dataRestituzionePrevista;
    
    @Column(name = "rest_effettiva")
    private String dataRestituzioneEffettiva;

    public Prestito() {}

   	public Prestito(Utente utente, Libro libro, Rivista rivista, String dataInizioPrestito, String dataRestituzionePrevista, String dataRestituzioneEffettiva) throws ParseException {
        this.utente = utente;
        this.libro = libro;
        this.rivista = rivista;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
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

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Rivista getRivista() {
		return rivista;
	}

	public void setRivista(Rivista rivista) {
		this.rivista = rivista;
	}

	public boolean isRestituito() {
        return this.dataRestituzioneEffettiva != "";
    }

	public boolean isScaduto() {
		LocalDateTime ldt = LocalDateTime.now();
        String formattedDateStr = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALY).format(ldt);
		if(formattedDateStr != dataRestituzionePrevista ) {
			return true;
		}
		return false;
	}
}
