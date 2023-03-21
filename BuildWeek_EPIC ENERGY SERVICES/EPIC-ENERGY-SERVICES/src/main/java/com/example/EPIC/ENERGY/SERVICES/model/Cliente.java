package com.example.EPIC.ENERGY.SERVICES.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ragioneSociale;
    private String partitaIva;
    private String email;
    private LocalDate dataInserimento;
    private LocalDate dataUltimoContatto;
    private BigDecimal fatturatoAnnuale;
    private String pec;
    private String telefono;
    private String emailContatto;
    private String nomeContatto;
    private String cognomeContatto;
    private String telefonoContatto;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Indirizzo> indirizzi = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Fattura> fatture = new ArrayList<>();

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public LocalDate getDataUltimoContatto() {
		return dataUltimoContatto;
	}

	public void setDataUltimoContatto(LocalDate dataUltimoContatto) {
		this.dataUltimoContatto = dataUltimoContatto;
	}

	public BigDecimal getFatturatoAnnuale() {
		return fatturatoAnnuale;
	}

	public void setFatturatoAnnuale(BigDecimal fatturatoAnnuale) {
		this.fatturatoAnnuale = fatturatoAnnuale;
	}

	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String getEmailContatto() {
		return emailContatto;
	}

	public void setEmailContatto(String emailContatto) {
		this.emailContatto = emailContatto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNomeContatto() {
		return nomeContatto;
	}

	public void setNomeContatto(String nomeContatto) {
		this.nomeContatto = nomeContatto;
	}

	public String getCognomeContatto() {
		return cognomeContatto;
	}

	public void setCognomeContatto(String cognomeContatto) {
		this.cognomeContatto = cognomeContatto;
	}

	public String getTelefonoContatto() {
		return telefonoContatto;
	}

	public void setTelefonoContatto(String telefonoContatto) {
		this.telefonoContatto = telefonoContatto;
	}

    // costruttori, getter e setter, metodi ausiliari
}
