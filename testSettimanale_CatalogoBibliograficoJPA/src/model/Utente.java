package model;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;

    private String numeroTessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    // costruttori, getter e setter
}
