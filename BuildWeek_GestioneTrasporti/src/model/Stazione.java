package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

@Entity
public class Stazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "stazionePartenza", cascade = CascadeType.ALL)
    private List<Viaggio> viaggiInPartenza;

    @OneToMany(mappedBy = "stazioneArrivo", cascade = CascadeType.ALL)
    private List<Viaggio> viaggiInArrivo;

    public Stazione() {
        // Costruttore vuoto richiesto da JPA
    }

    public Stazione(String nome) {
        this.nome = nome;
        this.viaggiInPartenza = new ArrayList<>();
        this.viaggiInArrivo = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Viaggio> getViaggiInPartenza() {
        return viaggiInPartenza;
    }

    public void setViaggiInPartenza(List<Viaggio> viaggiInPartenza) {
        this.viaggiInPartenza = viaggiInPartenza;
    }

    public List<Viaggio> getViaggiInArrivo() {
        return viaggiInArrivo;
    }

    public void setViaggiInArrivo(List<Viaggio> viaggiInArrivo) {
        this.viaggiInArrivo = viaggiInArrivo;
    }

    public void addViaggioInPartenza(Viaggio viaggio) {
        viaggiInPartenza.add(viaggio);
        viaggio.setStazionePartenza(this);
    }

    public void removeViaggioInPartenza(Viaggio viaggio) {
        viaggiInPartenza.remove(viaggio);
        viaggio.setStazionePartenza(null);
    }

    public void addViaggioInArrivo(Viaggio viaggio) {
        viaggiInArrivo.add(viaggio);
        viaggio.setStazioneArrivo(this);
    }

    public void removeViaggioInArrivo(Viaggio viaggio) {
        viaggiInArrivo.remove(viaggio);
        Tratta tratta = viaggio.getTratte().stream()
                .filter(t -> t.getStazioneArrivo().equals(this))
                .findFirst()
                .orElse(null);
        if (tratta != null) {
            viaggio.removeTratta(tratta);
        }
        viaggio.setStazioneArrivo(null);
    }

    public static List<Stazione> findAll(EntityManager em) {
        TypedQuery<Stazione> query = em.createQuery("SELECT s FROM Stazione s", Stazione.class);
        return query.getResultList();
    }

    public static Stazione findById(Long id, EntityManager em) {
        return em.find(Stazione.class, id);
    }

}






