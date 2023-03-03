package com.example.gestioneprenotazioni.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String citta;

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private Set<Postazione> postazioni = new HashSet<>();

    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public void addPostazione(Postazione postazione) {
        postazioni.add(postazione);
        postazione.setEdificio(this);
    }

    public void removePostazione(Postazione postazione) {
        postazioni.remove(postazione);
        postazione.setEdificio(null);
    }

    // Override di equals e hashCode per considerare solo l'id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edificio edificio = (Edificio) o;
        return id != null && id.equals(edificio.getId());
    }

    private Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public int hashCode() {
        return getClass().hashCode();
    }
}  
