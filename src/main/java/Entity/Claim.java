package Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataApertura;

    private LocalDate dataChiusura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    // 🔗 Perizia collegata
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private Expertise expertise;

    // 🔗 Compensazione economica
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private Compensation compensation;

    // 🔗 Assicurato
    @ManyToOne
    @JoinColumn(name = "insured_id", nullable = false)
    private Insured insured;

    // 🔗 Veicolo del sinistro
    @ManyToOne
    @JoinColumn(name = "veicolo_id", nullable = false)
    private Vehicle veicolo;

    // 🔗 Controparte (può essere null)
    @ManyToOne
    @JoinColumn(name = "controparte_id")
    private Counterpart counterpart;

    public Claim() {}

    public Claim(LocalDate dataApertura, State state, Insured insured, Vehicle veicolo) {
        this.dataApertura = dataApertura;
        this.state = state;
        this.insured = insured;
        this.veicolo = veicolo;
    }

    // --- Getter & Setter ---
    public Long getId() { return id; }

    public LocalDate getDataApertura() { return dataApertura; }
    public void setDataApertura(LocalDate dataApertura) { this.dataApertura = dataApertura; }

    public LocalDate getDataChiusura() { return dataChiusura; }
    public void setDataChiusura(LocalDate dataChiusura) { this.dataChiusura = dataChiusura; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public Expertise getExpertise() { return expertise; }
    public void setExpertise(Expertise expertise) { this.expertise = expertise; }

    public Compensation getCompensation() { return compensation; }
    public void setCompensation(Compensation compensation) { this.compensation = compensation; }

    public Insured getInsured() { return insured; }
    public void setInsured(Insured insured) { this.insured = insured; }

    public Vehicle getVeicolo() { return veicolo; }
    public void setVeicolo(Vehicle veicolo) { this.veicolo = veicolo; }

    public Counterpart getControparte() { return counterpart; }
    public void setControparte(Counterpart counterpart) { this.counterpart = counterpart; }
}
