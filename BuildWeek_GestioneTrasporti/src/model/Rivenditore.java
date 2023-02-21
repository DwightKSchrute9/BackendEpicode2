package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rivenditore {

  @Id
  @GeneratedValue
  private Long id;

  private String nome;

  private String indirizzo;

  private String citta;

  private String telefono;

  public Rivenditore() {}

  public Rivenditore(String nome, String indirizzo, String citta, String telefono) {
    this.nome = nome;
    this.indirizzo = indirizzo;
    this.citta = citta;
    this.telefono = telefono;
  }

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

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public String getCitta() {
    return citta;
  }

  public void setCitta(String citta) {
    this.citta = citta;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
