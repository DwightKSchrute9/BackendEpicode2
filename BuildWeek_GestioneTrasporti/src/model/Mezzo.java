package model;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllMezzi", query = "SELECT m FROM Mezzo m"),
    @NamedQuery(name = "getMezziByTipo", query = "SELECT m FROM Mezzo m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "getMezziByTratta", query = "SELECT m FROM Mezzo m WHERE m.tratta = :tratta")
})
public class Mezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private Integer capienza;

    private Boolean inServizio;

    @ManyToOne
    private Tratta tratta;

    public Mezzo() {
        // default constructor
    }

    public Mezzo(String tipo, Integer capienza, Boolean inServizio, Tratta tratta) {
        this.tipo = tipo;
        this.capienza = capienza;
        this.inServizio = inServizio;
        this.tratta = tratta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapienza() {
        return capienza;
    }

    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }

    public Boolean getInServizio() {
        return inServizio;
    }

    public void setInServizio(Boolean inServizio) {
        this.inServizio = inServizio;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }
}

