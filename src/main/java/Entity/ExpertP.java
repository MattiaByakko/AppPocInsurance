package Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "experts")
public class ExpertP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    @Column(unique = true)
    private String codiceFiscale;

    @Column(nullable = false)
    private String zonaDiCompetenza;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "expert", cascade = CascadeType.ALL)
    private List<Claim> claims;

    public ExpertP() {}

    public ExpertP(String nome, String cognome, String codiceFiscale, String zonaDiCompetenza, User user) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.zonaDiCompetenza = zonaDiCompetenza;
        this.user = user;
    }

    // --- GETTER & SETTER ---
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getCodiceFiscale() { return codiceFiscale; }
    public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }

    public String getZonaDiCompetenza() { return zonaDiCompetenza; }
    public void setZonaDiCompetenza(String zonaDiCompetenza) { this.zonaDiCompetenza = zonaDiCompetenza; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Claim> getClaims() { return claims; }
    public void setClaims(List<Claim> claims) { this.claims = claims; }
}
