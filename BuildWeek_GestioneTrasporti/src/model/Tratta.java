package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "findTrattaByViaggioId", query = "SELECT t FROM Tratta t WHERE t.viaggio.id = :idViaggio"),
    @NamedQuery(name = "findTrattaByCapolinea", query = "SELECT t FROM Tratta t WHERE t.capolinea = :capolinea")
})
public class Tratta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zonaPartenza;

    private String capolinea;

    private Integer tempoMedioPercorrenza;

    private Integer numeroPercorsi;

    private Integer tempoEffettivoPercorrenza;

    @ManyToOne
    private Viaggio viaggio;

    public Tratta() {
    }

    public Tratta(String zonaPartenza, String capolinea, Integer tempoMedioPercorrenza, Integer numeroPercorsi, Integer tempoEffettivoPercorrenza, Viaggio viaggio) {
        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
        this.numeroPercorsi = numeroPercorsi;
        this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
        this.viaggio = viaggio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public Integer getTempoMedioPercorrenza() {
        return tempoMedioPercorrenza;
    }

    public void setTempoMedioPercorrenza(Integer tempoMedioPercorrenza) {
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
    }

    public Integer getNumeroPercorsi() {
        return numeroPercorsi;
    }

    public void setNumeroPercorsi(Integer numeroPercorsi) {
        this.numeroPercorsi = numeroPercorsi;
    }

    public Integer getTempoEffettivoPercorrenza() {
        return tempoEffettivoPercorrenza;
    }

    public void setTempoEffettivoPercorrenza(Integer tempoEffettivoPercorrenza) {
        this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

	public int get_distance() {
		// TODO Auto-generated method stub
		return 0;
	}
}

