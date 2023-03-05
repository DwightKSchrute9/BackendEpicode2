package com.example.gestioneprenotazioni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = "postazione")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codice;

    @Column
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoPostazione tipo;

    @Column
    private int numMaxOccupanti;

    @ManyToOne
    @JoinColumn(name="edificio", nullable=false)
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private Set<Prenotazione> prenotazioni;

    public Postazione() {
    }

    public Postazione(String codice, String descrizione, TipoPostazione tipo, int numMaxOccupanti, Edificio edificio) {
        this.setCodice(codice);
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numMaxOccupanti = numMaxOccupanti;
        this.edificio = edificio;
    }

    public void addPrenotazione(Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
        prenotazione.setPostazione(this);
    }

    public void removePrenotazione(Prenotazione prenotazione) {
        prenotazioni.remove(prenotazione);
        prenotazione.setPostazione(null);
    }

    // Override di equals e hashCode per considerare solo l'id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postazione postazione = (Postazione) o;
        return id != null && id.equals(postazione.getId());
    }

	@Override
    public int hashCode() {
        return getClass().hashCode();
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoPostazione getTipo() {
		return tipo;
	}

	public void setTipo(TipoPostazione tipo) {
		this.tipo = tipo;
	}

	public int getNumMaxOccupanti() {
		return numMaxOccupanti;
	}

	public void setNumMaxOccupanti(int numMaxOccupanti) {
		this.numMaxOccupanti = numMaxOccupanti;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public String getCitta() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

