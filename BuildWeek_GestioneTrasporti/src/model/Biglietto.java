package model;


@Entity
public class Biglietto {

  @Id
  @GeneratedValue
  private Long id;

  private String codice;

  private Double prezzo;
  
  private LocalDateTime emissionDateTime;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataEmissione;
  
  @ManyToOne
  @JoinColumn(name = "emission_point_id")
  private EmissionPoint emissionPoint;

  // costruttori, getter e setter
}