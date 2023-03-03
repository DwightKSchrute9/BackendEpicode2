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
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int numMaxOccupanti;

    @ManyToOne
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private Set<Prenotazione> prenotazioni;

    public Postazione() {
    }

    public Postazione(String codice, String descrizione, TipoPostazione tipo, int numMaxOccupanti, Edificio edificio) {
        this.codice = codice;
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

    private Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public int hashCode() {
        return getClass().hashCode();
    }

	public Collection<LocalDate> getPrenotazioni() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEdificio(Edificio edificio2) {
		// TODO Auto-generated method stub
		
	}

	public void setPrenotazioni(Collection<LocalDate> prenotazioniPostazione) {
		// TODO Auto-generated method stub
		
	}

	public void setDescrizione(String string) {
		// TODO Auto-generated method stub
		
	}
}

