package Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assessment")
public class Assesment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate assessmentDate;

    private double importStimade;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private AssessmentState state;

    private String documentPdfUrl;

    // Relazione 1:1 con Sinistro
    @OneToOne
    @JoinColumn(name = "claim_id", referencedColumnName = "id")
    private Claim claim;

    // Relazione con Perito (che è un tipo di Utente)
    @ManyToOne
    @JoinColumn(name = "expertP_id")
    private ExpertP expertP;

    public Assesment() {}

    public Assesment(LocalDate assessmentDate, double importStimade, String technicalNote,
                   AssesmentState state, String documentPdfUrl, Claim claim, Assesment assessment) {
        this.assessmentDate = assessmentDate;
        this.importStimade = importStimade;
        this.technicalNote = technicalNote;
        this.state = state;
        this.documentPdfUrl = documentPdfUrl;
        this.claim = claim;
        this.expertP = expertP();
    }

}
