package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Biglietto<E extends DistributoreAutomatico, T extends Mezzo> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private E partenza;

  @ManyToOne
  private E arrivo;

  @ManyToOne
  private T mezzo;
  
  @ManyToOne
  @JoinColumn(name = "prenotazione_id")
  private Prenotazione prenotazione;


  private Double prezzo;

  public Biglietto() {}

  public Biglietto(E partenza, E arrivo, T mezzo, Double prezzo) {
    this.partenza = partenza;
    this.arrivo = arrivo;
    this.mezzo = mezzo;
    this.prezzo = prezzo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public E getPartenza() {
    return partenza;
  }

  public void setPartenza(E partenza) {
    this.partenza = partenza;
  }

  public E getArrivo() {
    return arrivo;
  }

  public void setArrivo(E arrivo) {
    this.arrivo = arrivo;
  }

  public T getMezzo() {
    return mezzo;
  }

  public void setMezzo(T mezzo) {
    this.mezzo = mezzo;
  }

  public Double getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(Double prezzo) {
    this.prezzo = prezzo;
  }

public void setPrenotazione(Prenotazione prenotazione2) {
	// TODO Auto-generated method stub
	
}

}
