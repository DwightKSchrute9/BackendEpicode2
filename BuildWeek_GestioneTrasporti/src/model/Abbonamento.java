package model;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Abbonamento.findAll", query = "SELECT a FROM Abbonamento a"),
    @NamedQuery(name = "Abbonamento.findByUser", query = "SELECT a FROM Abbonamento a WHERE a.user = :user")
})
@Table(name = "Abbonamento")
public class Abbonamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "emission_datetime")
    private LocalDateTime emissionDateTime;

    @ManyToOne
    @JoinColumn(name = "emission_point_id")
    private DistributoreAutomatico<?> emissionPoint;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "expiration_datetime")
    private LocalDateTime expirationDateTime;

    // constructors, getters and setters
    
    public Abbonamento() {
        // default constructor
    }

    public Abbonamento(String code, LocalDateTime emissionDateTime, DistributoreAutomatico<?> emissionPoint, 
                       User user, LocalDateTime expirationDateTime) {
        this.code = code;
        this.emissionDateTime = emissionDateTime;
        this.emissionPoint = emissionPoint;
        this.user = user;
        this.expirationDateTime = expirationDateTime;
    }
    
    // getters and setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getEmissionDateTime() {
        return emissionDateTime;
    }

    public void setEmissionDateTime(LocalDateTime emissionDateTime) {
        this.emissionDateTime = emissionDateTime;
    }

    public DistributoreAutomatico<?> getEmissionPoint() {
        return emissionPoint;
    }

    public void setEmissionPoint(DistributoreAutomatico<?> emissionPoint) {
        this.emissionPoint = emissionPoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(LocalDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    public double getPrezzo() {
        // Calcola la durata dell'abbonamento in ore
        long durataInOre = Duration.between(emissionDateTime, expirationDateTime).toHours();
        
        // Calcola il prezzo dell'abbonamento in base alla durata e al prezzo base
        double prezzoBase = 10.0;  // Prezzo base dell'abbonamento
        double prezzo = prezzoBase * Math.ceil(durataInOre / 24.0);  // Calcola il prezzo arrotondando per eccesso alla giornata successiva

        return prezzo;
    }
}
