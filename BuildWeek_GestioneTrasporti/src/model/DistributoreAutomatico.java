package model;


@Entity
public class DistributoreAutomatico {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private EmissionPointType type;
    
    private String name;
    
    private boolean isActive;


  // costruttori, getter e setter
}