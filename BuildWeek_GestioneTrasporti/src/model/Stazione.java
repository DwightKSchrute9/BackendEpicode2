package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "partenza", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratta> tratteInPartenza = new ArrayList<>();

    @OneToMany(mappedBy = "arrivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratta> tratteInArrivo = new ArrayList<>();

    public Stazione() {}

    public Stazione(String nome) {
        this.nome = nome;
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

    public List<Tratta> getTratteInPartenza() {
        return tratteInPartenza;
    }

    public void setTratteInPartenza(List<Tratta> tratteInPartenza) {
        this.tratteInPartenza = tratteInPartenza;
    }

    public List<Tratta> getTratteInArrivo() {
        return tratteInArrivo;
    }

    public void setTratteInArrivo(List<Tratta> tratteInArrivo) {
        this.tratteInArrivo = tratteInArrivo;
    }

    public static List<Stazione> findAll(EntityManager em) {
        TypedQuery<Stazione> query = em.createQuery("SELECT s FROM Stazione s", Stazione.class);
        return query.getResultList();
    }

    public static Stazione findById(Long id, EntityManager em) {
        return em.find(Stazione.class, id);
    }

    public static Stazione findByNome(String nome, EntityManager em) {
        TypedQuery<Stazione> query = em.createNamedQuery("findStazioneByNome", Stazione.class);
        query.setParameter("nome", nome);
        return query.getSingleResult();
    }

    public List<Tratta> getTratteInPartenzaByData(String data, EntityManager em) {
        TypedQuery<Tratta> query = em.createNamedQuery("findTratteInPartenzaByData", Tratta.class);
        query.setParameter("partenzaId", this.getId());
        query.setParameter("data", data);
        return query.getResultList();
    }

    public List<Tratta> getTratteInArrivoByData(String data, EntityManager em) {
        TypedQuery<Tratta> query = em.createNamedQuery("findTratteInArrivoByData", Tratta.class);
        query.setParameter("arrivoId", this.getId());
        query.setParameter("data", data);
        return query.getResultList();
    }
}

