package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
@Table (name = "Utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tessera")
    private int idTessera;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private String dataNascita;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;
    
    public Utente() {}
    
    public Utente(int idTessera, String nome, String cognome, String dataNascita) {
    	this.idTessera = idTessera;
    	this.nome = nome;
    	this.cognome = cognome;
    	this.dataNascita = dataNascita;
    }

	public int getIdTessera() {
		return idTessera;
	}

	public void setIdTessera(int idTessera) {
		this.idTessera = idTessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	
    
}
