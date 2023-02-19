package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "catalogo")
    private List<Libro> libri;

    @OneToMany(mappedBy = "catalogo")
    private List<Rivista> riviste;

    public Catalogo() {
        this.libri = new ArrayList<>();
        this.riviste = new ArrayList<>();
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public List<Rivista> getRiviste() {
        return riviste;
    }

    public void aggiungiLibro(Libro libro) {
        this.libri.add(libro);
        libro.setCatalogo(this);
    }

    public void rimuoviLibro(Libro libro) {
        this.libri.remove(libro);
        libro.setCatalogo(null);
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void aggiungiRivista(Rivista rivista) {
        this.riviste.add(rivista);
        rivista.setCatalogo(this);
    }

    public void rimuoviRivista(Rivista rivista) {
        this.riviste.remove(rivista);
        rivista.setCatalogo(null);
    }

    // implementazione dei metodi di ricerca
}
