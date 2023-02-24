package model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "findDistributorByName", query = "SELECT d FROM DistributoreAutomatico d WHERE d.name = :name")
})
public class DistributoreAutomatico<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isActive;

    private String indirizzo;

    private double latitudine;

    private double longitudine;

    private double cassa;

    public DistributoreAutomatico() {
        // default constructor
    }

    public DistributoreAutomatico(String name, boolean isActive, String indirizzo, double latitudine, double longitudine, double cassa) {
        this.name = name;
        this.isActive = isActive;
        this.indirizzo = indirizzo;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.cassa = cassa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public double getCassa() {
        return cassa;
    }

    public void setCassa(double cassa) {
        this.cassa = cassa;
    }

    public static DistributoreAutomatico getDistributoreAutomatico(String name, List<DistributoreAutomatico> distributori) {
        for (DistributoreAutomatico d : distributori) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    public void caricaCassa(double amount) {
        this.cassa += amount;
    }

}


