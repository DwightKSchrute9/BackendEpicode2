package gestioneParcoMezzi;


@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private VehicleType type;
    
    private int capacity;
    
    private boolean isInService;
    
    // ... altri attributi e metodi
}
