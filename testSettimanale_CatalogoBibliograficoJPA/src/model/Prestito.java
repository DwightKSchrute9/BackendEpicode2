package model;


@Entity
public class Prestito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Utente utente;
    
    @ManyToOne
    @JoinColumn(name = "catalogoItem_id")
    private CatalogoItem catalogoItem;
    
    @Temporal(TemporalType.DATE)
    private Date dataInizioPrestito;
    
    @Temporal(TemporalType.DATE)
    private Date dataRestituzionePrevista;
    
    @Temporal(TemporalType.DATE)
    private Date dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, CatalogoItem catalogoItem, Date dataInizioPrestito) {
        this.utente = utente;
        this.catalogoItem = catalogoItem;
        this.dataInizioPrestito = dataInizioPrestito;
        Calendar c = Calendar.getInstance();
        c.setTime(dataInizioPrestito);
        c.add(Calendar.DATE, 30);
        this.dataRestituzionePrevista = c.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public CatalogoItem getCatalogoItem() {
        return catalogoItem;
    }

    public void setCatalogoItem(CatalogoItem catalogoItem) {
        this.catalogoItem = catalogoItem;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public boolean isRestituito() {
        return this.dataRestituzioneEffettiva != null;
    }

    public boolean isScaduto() {
        Date oggi = new Date();
        return oggi.after(this.dataRestituzionePrevista) && !this.isRestituito();
    }
}
