package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

@SuppressWarnings("hiding")
@Entity
@Table(name = "biglietto")
@NamedQueries({
  @NamedQuery(name = "Biglietto.findByCodice", query = "SELECT b FROM Biglietto b WHERE b.codice = :codice"),
  @NamedQuery(name = "Biglietto.findByDataEmissione", query = "SELECT b FROM Biglietto b WHERE b.dataEmissione = :dataEmissione"),
  @NamedQuery(name = "Biglietto.findByUser", query = "SELECT b FROM Biglietto b WHERE b.user = :user"),
  @NamedQuery(name = "Biglietto.findByViaggio", query = "SELECT b FROM Biglietto b WHERE b.viaggio = :viaggio"),
  @NamedQuery(name = "Biglietto.findByEmissionPoint", query = "SELECT b FROM Biglietto b WHERE b.emissionPoint = :emissionPoint")
})
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
  private DistributoreAutomatico<?> emissionPoint;

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
    this.emissionPoint = (DistributoreAutomatico<?>) emissionPoint;
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

  @SuppressWarnings("unchecked")
public EmissionPoint getEmissionPoint() {
    return (EmissionPoint) emissionPoint;
  }

  public void setEmissionPoint(EmissionPoint emissionPoint) {
    this.emissionPoint = (DistributoreAutomatico<?>) emissionPoint;
  }

  public User getUser() {
	    return user;
	  }

	  public void setUser(User user) {
	    this.user = user;
	  }

	  @SuppressWarnings("unchecked")
	public Viaggio getViaggio() {
	    return (Viaggio) viaggio;
	  }

	  public void setViaggio(Viaggio viaggio) {
	    this.viaggio = (Tratta) viaggio;
	  }
	  @Override
	  public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      Biglietto<?, ?> biglietto = (Biglietto<?, ?>) o;
	      return Objects.equals(codice, biglietto.codice) &&
	              Objects.equals(emissionDateTime, biglietto.emissionDateTime) &&
	              Objects.equals(user, biglietto.user) &&
	              Objects.equals(emissionPoint, biglietto.emissionPoint) &&
	              Objects.equals(viaggio, biglietto.viaggio);
	  }

	  @Override
	  public int hashCode() {
	      return Objects.hash(codice, emissionDateTime, user, emissionPoint, viaggio);
	  }

	}

