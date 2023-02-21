package model;


@Entity
public class Tessera {

  @Id
  @GeneratedValue
  private Long id;

  private String codice;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataEmissione;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataScadenza;

  // costruttori, getter e setter
}
