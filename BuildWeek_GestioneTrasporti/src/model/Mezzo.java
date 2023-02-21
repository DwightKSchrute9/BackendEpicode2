package model;

@Entity
public class Mezzo {

  @Id
  @GeneratedValue
  private Long id;

  private String tipo;

  private Integer capienza;

  private Boolean inServizio;

  @ManyToOne
  private Tratta tratta;

  // costruttori, getter e setter
}