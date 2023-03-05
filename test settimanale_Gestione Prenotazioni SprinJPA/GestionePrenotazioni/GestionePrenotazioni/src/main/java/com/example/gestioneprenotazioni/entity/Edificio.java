package com.example.gestioneprenotazioni.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "edificio")
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
    
    public Edificio() {
    	
    }

    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    /*
    public void addPostazione(Postazione postazione) {
        postazioni.add(postazione);
        postazione.setEdificio(this);
    }

    public void removePostazione(Postazione postazione) {
        postazioni.remove(postazione);
        postazione.setEdificio(null);
    }
    */

    // Override di equals e hashCode per considerare solo l'id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edificio edificio = (Edificio) o;
        return id != null && id == edificio.getId();
    }

	@Override
    public int hashCode() {
        return getClass().hashCode();
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Set<Postazione> getPostazioni() {
		return postazioni;
	}

	public void setPostazioni(Set<Postazione> postazioni) {
		this.postazioni = postazioni;
	}
	
	
}  
