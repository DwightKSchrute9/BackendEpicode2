package com.example.gestioneprenotazioni.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Prenotazione {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate dataPrenotazione;

  @ManyToOne
  private Postazione postazione;

  @ManyToOne
  private Utente utente;

  public Prenotazione() {}

  public Prenotazione(LocalDate dataPrenotazione, Postazione postazione, Utente utente) {
    this.dataPrenotazione = dataPrenotazione;
    this.postazione = postazione;
    this.utente = utente;
  }

  public boolean isAvailable(LocalDate data) {
    Set<LocalDate> prenotazioni = this.postazione.getPrenotazioni()
        .stream()
        .map(prenotazione -> prenotazione.getDataPrenotazione())
        .collect(Collectors.toSet());
    return !prenotazioni.contains(data);
  }

  public boolean isBookedBy(Utente utente) {
    Set<Prenotazione> prenotazioniUtente = this.postazione.getPrenotazioni()
        .stream()
        .filter(p -> p.getUtente().equals(utente))
        .collect(Collectors.toSet());
    return !prenotazioniUtente.isEmpty();
  }

  public void prenota(Utente utente, LocalDate dataPrenotazione) {
    if (isAvailable(dataPrenotazione)) {
      Prenotazione prenotazione = new Prenotazione(dataPrenotazione, this.postazione, utente);
      Set<Prenotazione> prenotazioniPostazione = this.postazione.getPrenotazioni();
      prenotazioniPostazione.add(prenotazione);
      this.postazione.setPrenotazioni(prenotazioniPostazione);
    } else {
      throw new IllegalStateException("Postazione non disponibile per la data specificata");
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDataPrenotazione() {
    return dataPrenotazione;
  }

  public void setDataPrenotazione(LocalDate dataPrenotazione) {
    this.dataPrenotazione = dataPrenotazione;
  }

  public Postazione getPostazione() {
    return postazione;
  }

  public void setPostazione(Postazione postazione) {
    this.postazione = postazione;
  }


  public Utente getUtente() {
    return utente;
  }

  public void setUtente(Utente utente) {
    this.utente = utente;
  }

}
