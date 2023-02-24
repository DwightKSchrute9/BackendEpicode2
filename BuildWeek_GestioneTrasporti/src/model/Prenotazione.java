package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Prenotazione {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime dataPrenotazione;

  private Boolean confermata;

  @ManyToOne
  private User user;

  @ManyToOne
  private Viaggio viaggio;

  @SuppressWarnings("rawtypes")
@OneToMany(mappedBy = "prenotazione", cascade = CascadeType.ALL)
  private List<Biglietto> biglietti;

  public Prenotazione() {
    // default constructor
  }

  public Prenotazione(LocalDateTime dataPrenotazione, Boolean confermata, User user, Viaggio viaggio, @SuppressWarnings("rawtypes") List<Biglietto> biglietti) {
    this.dataPrenotazione = dataPrenotazione;
    this.confermata = confermata;
    this.user = user;
    this.viaggio = viaggio;
    this.biglietti = biglietti;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDataPrenotazione() {
    return dataPrenotazione;
  }

  public void setDataPrenotazione(LocalDateTime dataPrenotazione) {
    this.dataPrenotazione = dataPrenotazione;
  }

  public Boolean getConfermata() {
    return confermata;
  }

  public void setConfermata(Boolean confermata) {
    this.confermata = confermata;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Viaggio getViaggio() {
    return viaggio;
  }

  public void setViaggio(Viaggio viaggio) {
    this.viaggio = viaggio;
  }

  @SuppressWarnings("rawtypes")
public List<Biglietto> getBiglietti() {
    return biglietti;
  }

  public void setBiglietti(@SuppressWarnings("rawtypes") List<Biglietto> biglietti) {
    this.biglietti = biglietti;
  }

  public static Prenotazione findById(Long id, EntityManager em) {
    return em.find(Prenotazione.class, id);
  }

  public static List<Prenotazione> findByUser(User user, EntityManager em) {
    TypedQuery<Prenotazione> query = em.createQuery("SELECT p FROM Prenotazione p WHERE p.user = :user", Prenotazione.class);
    query.setParameter("user", user);
    return query.getResultList();
  }

  public void aggiungi(Biglietto<?, ?> biglietto) throws Exception {
    if (biglietti.contains(biglietto)) {
      throw new Exception("Questo biglietto è già stato prenotato!");
    }
    biglietti.add(biglietto);
    biglietto.setPrenotazione(this);
  }

}



