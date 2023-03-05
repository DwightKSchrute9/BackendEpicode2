package com.example.gestioneprenotazioni.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "utente")
public class Utente {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  // i campi nome e cognome possono essere utili per gestire il nome completo dell'utente
  
  @Column(nullable = false)
  private String nome;
  
  @Column(nullable = false)
  private String cognome;
  
  // un campo email può essere utile per contattare l'utente
  
  @Column(nullable = false, unique = true)
  private String email;
  
  // ogni utente può avere molte prenotazioni
  @OneToMany(mappedBy = "utente")
  private Set<Prenotazione> prenotazioni = new HashSet<>();
  
  // costruttore vuoto necessario per JPA
  public Utente() {}
  
  // costruttore con nome e cognome
  public Utente(String nome, String cognome, String email) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
  }
  
  // costruttore con nome, cognome e prenotazioni
  public Utente(String nome, String cognome, String email, Set<Prenotazione> prenotazioni) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.prenotazioni = prenotazioni;
  }
  
  // getter e setter per tutti i campi
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getCognome() {
    return cognome;
  }
  
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public Set<Prenotazione> getPrenotazioni() {
    return prenotazioni;
  }
  
  public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
    this.prenotazioni = prenotazioni;
  }
  
  // metodo per aggiungere una prenotazione all'insieme di prenotazioni dell'utente
  public void addPrenotazione(Prenotazione prenotazione) {
    prenotazioni.add(prenotazione);
  }
  
  // metodo per rimuovere una prenotazione dall'insieme di prenotazioni dell'utente
  public void removePrenotazione(Prenotazione prenotazione) {
    prenotazioni.remove(prenotazione);
  }
  
  // metodo per rimuovere tutte le prenotazioni dall'insieme di prenotazioni dell'utente
  public void clearPrenotazioni() {
    prenotazioni.clear();
  }
  
}
