package model;


@Entity
public class Abbonamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;

	private LocalDateTime emissionDateTime;

	@ManyToOne
	@JoinColumn(name = "emission_point_id")
	private EmissionPoint emissionPoint;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private LocalDateTime expirationDateTime

  // costruttori, getter e setter
}



