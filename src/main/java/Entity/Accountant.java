package Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "accountants")
public class Accountant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    @Column(unique = true, nullable = false)
    private String codiceFiscale;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "accountant", cascade = CascadeType.ALL)
    private List<Compensation> compensations;

    public Accountant() {}

    public Accountant(String nome, String cognome, String codiceFiscale, User user) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.user = user;
    }

    // --- Getter & Setter ---
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getCodiceFiscale() { return codiceFiscale; }
    public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Compensation> getCompensations() { return compensations; }
    public void setCompensations(List<Compensation> compensations) { this.compensations = compensations; }
}
