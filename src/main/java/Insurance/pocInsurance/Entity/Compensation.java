package pocInsurance.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "compensations")
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal importoStimato;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal massimale;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompensationState stato;

    @ManyToOne
    @JoinColumn(name = "accountant_id", nullable = false)
    private Accountant accountant;

    @OneToOne
    @JoinColumn(name = "claim_id", nullable = false, unique = true)
    private Claim claim;

    public Compensation() {}

    public Compensation(BigDecimal importoStimato, BigDecimal massimale, CompensationState stato, Accountant accountant, Claim claim) {
        this.importoStimato = importoStimato;
        this.massimale = massimale;
        this.stato = stato;
        this.accountant = accountant;
        this.claim = claim;
    }

    // --- Getter & Setter ---
    public Long getId() { return id; }

    public BigDecimal getImportoStimato() { return importoStimato; }
    public void setImportoStimato(BigDecimal importoStimato) { this.importoStimato = importoStimato; }

    public BigDecimal getMassimale() { return massimale; }
    public void setMassimale(BigDecimal massimale) { this.massimale = massimale; }

    public CompensationState getStato() { return stato; }
    public void setStato(CompensationState stato) { this.stato = stato; }

    public Accountant getAccountant() { return accountant; }
    public void setAccountant(Accountant accountant) { this.accountant = accountant; }

    public Claim getClaim() { return claim; }
    public void setClaim(Claim claim) { this.claim = claim; }
}
