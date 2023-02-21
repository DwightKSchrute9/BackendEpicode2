package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "biglietto")
public class Biglietto<EmissionPoint, Viaggio> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String codice;

  private Double prezzo;

  @Column(name = "emission_date_time")
  private LocalDateTime emissionDateTime;

  @Column(name = "data_emissione")
  private LocalDate dataEmissione;

  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emission_point_id")
  private DistributoreAutomatico emissionPoint;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "viaggio_id")
  private Tratta viaggio;

  

  public Biglietto() {
    // default constructor
  }

  public Biglietto(String codice, Double prezzo, LocalDateTime emissionDateTime, LocalDate dataEmissione,
      EmissionPoint emissionPoint, User user, Viaggio viaggio) {
    this.codice = codice;
    this.prezzo = prezzo;
    this.emissionDateTime = emissionDateTime;
    this.dataEmissione = dataEmissione;
    this.emissionPoint = (DistributoreAutomatico) emissionPoint;
    this.user = user;
    this.viaggio = (Tratta) viaggio;
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

  public Double getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(Double prezzo) {
    this.prezzo = prezzo;
  }

  public LocalDateTime getEmissionDateTime() {
    return emissionDateTime;
  }

  public void setEmissionDateTime(LocalDateTime emissionDateTime) {
    this.emissionDateTime = emissionDateTime;
  }

  public LocalDate getDataEmissione() {
    return dataEmissione;
  }

  public void setDataEmissione(LocalDate dataEmissione) {
    this.dataEmissione = dataEmissione;
  }

  public EmissionPoint getEmissionPoint() {
    return (EmissionPoint) emissionPoint;
  }

  public void setEmissionPoint(EmissionPoint emissionPoint) {
    this.emissionPoint = (DistributoreAutomatico) emissionPoint;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Viaggio getViaggio() {
    return (Viaggio) viaggio;
  }

  public void setViaggio(Viaggio viaggio) {
    this.viaggio = (Tratta) viaggio;
  }
}

 
