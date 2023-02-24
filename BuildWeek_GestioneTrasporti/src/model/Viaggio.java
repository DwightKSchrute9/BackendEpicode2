package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@NamedQuery(name = "findViaggiByTrattaId", query = "SELECT v FROM Viaggio v JOIN v.tratte t WHERE t.id = :trattaId")
public class Viaggio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private Double prezzo;

        @OneToMany(mappedBy = "viaggio", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Tratta> tratte = new ArrayList<>();

        @ManyToOne
        @JoinColumn(name = "partenza_id")
        private Stazione stazionePartenza;

        @ManyToOne
        @JoinColumn(name = "arrivo_id")
        private Stazione stazioneArrivo;

        // costruttori, getter e setter

        public void setStazionePartenza1(Stazione stazionePartenza) {
            this.stazionePartenza = stazionePartenza;
            stazionePartenza.getViaggiInPartenza().add(this);
        }

        public void setStazioneArrivo1(Stazione stazioneArrivo) {
            this.stazioneArrivo = stazioneArrivo;
            stazioneArrivo.getViaggiInArrivo().add(this);
        }

        // altre implementazioni dei metodi
    


    public Viaggio() {
        // Costruttore vuoto richiesto da JPA
    }

    public Viaggio(String nome, Double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
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

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    public void addTratta(Tratta tratta) {
        tratte.add(tratta);
        tratta.setViaggio(this);
    }

    public void removeTratta(Tratta tratta) {
        tratte.remove(tratta);
        tratta.setViaggio(null);
    }

    public static List<Viaggio> findAll(EntityManager em) {
        TypedQuery<Viaggio> query = em.createQuery("SELECT v FROM Viaggio v", Viaggio.class);
        return query.getResultList();
    }

    public static Viaggio findById(Long id, EntityManager em) {
        return em.find(Viaggio.class, id);
    }

    public List<Tratta> getTratteByViaggioId(Long viaggioId, EntityManager em) {
        TypedQuery<Tratta> query = em.createNamedQuery("findTratteByViaggioId", Tratta.class);
        query.setParameter("viaggioId", viaggioId);
        return query.getResultList();
    }

    public List<Viaggio> getViaggiByTrattaId(Long trattaId, EntityManager em) {
        TypedQuery<Viaggio> query = em.createNamedQuery("findViaggiByTrattaId", Viaggio.class);
        query.setParameter("trattaId", trattaId);
        return query.getResultList();
    }

    public double get_sconto_abbonamento() {
        // TODO Auto-generated method stub
        return 0;
    }

    public double get_sconto_tessera() {
        // TODO Auto-generated method stub
        return 0;
    }

    public double paga(double d) {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isTrattaPresente(Long trattaId) {
        for (Tratta t : tratte) {
            if (t.getId().equals(trattaId)) {
                return true;
            }
        }
        return false;
    }
  
            
    public void setStazionePartenza(Stazione stazione) {
        if (!tratte.isEmpty()) {
            Tratta tratta = tratte.get(0);
            tratta.setStazionePartenza(stazione);
            stazione.getViaggiInPartenza().add(this);
        }
    }
    
    public void setStazioneArrivo(Stazione stazione) {
        if (!tratte.isEmpty()) {
            Tratta tratta = tratte.get(tratte.size() - 1);
            tratta.setStazioneArrivo(stazione);
            stazione.getViaggiInArrivo().add(this);
        }
    }
    
    public void setStazione(int index, Stazione stazione) {
        if (index < tratte.size()) {
            Tratta tratta = tratte.get(index);
            tratta.setStazioneArrivo(stazione);
            stazione.getViaggiInArrivo().add(this);
        }
    }
}
    



