package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Viaggio {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private Double prezzo;

  @OneToMany(mappedBy = "viaggio", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Tratta> tratte = new ArrayList<>();

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

  public Double getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(Double prezzo) {
    this.prezzo = prezzo;
  }

  public List<Tratta> getTratte() {
    return tratte;
  }

  public void setTratte(List<Tratta> tratte) {
    this.tratte = tratte;
  }

  // Costruttori, getter e setter
}

