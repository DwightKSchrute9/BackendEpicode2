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

public Viaggio() {
// default constructor
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
}
