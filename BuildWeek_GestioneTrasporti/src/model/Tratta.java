package model;


@Entity
public class Tratta {

  @Id
  @GeneratedValue
  private Long id;

  private String zonaPartenza;

  private String capolinea;

  private Integer tempoMedioPercorrenza;

  private Integer numeroPercorsi;

  private Integer tempoEffettivoPercorrenza;

  // costruttori, getter e setter
}



