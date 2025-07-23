package Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expertises")
public class Expertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descrizione;

    @Column(nullable = false)
    private LocalDate dataCreazione;

    @OneToOne
    @JoinColumn(name = "claim_id", nullable = false, unique = true)
    private Claim claim;

    @ManyToOne
    @JoinColumn(name = "expert_id", nullable = false)
    private ExpertP expert;

    public Expertise() {}

    public Expertise(String descrizione, LocalDate dataCreazione, Claim claim, ExpertP expert) {
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.claim = claim;
        this.expert = expert;
    }

    // --- Getter & Setter ---
    public Long getId() { return id; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public LocalDate getDataCreazione() { return dataCreazione; }
    public void setDataCreazione(LocalDate dataCreazione) { this.dataCreazione = dataCreazione; }

    public Claim getClaim() { return claim; }
    public void setClaim(Claim claim) { this.claim = claim; }

    public ExpertP getExpert() { return expert; }
    public void setExpert(ExpertP expert) { this.expert = expert; }
}
