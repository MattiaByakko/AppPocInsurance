package Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String place;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private ClaimState state;

    // Un sinistro può coinvolgere più veicoli
    @ManyToMany
    @JoinTable(
            name = "claim-vehicle",
            joinColumns = @JoinColumn(name = "claim_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private List<Vehicle> vehicleInvolved;

    // Più utenti coinvolti
    @ManyToMany
    @JoinTable(
            name = "claim_user",
            joinColumns = @JoinColumn(name = "claim_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userInvolved;

    // Un sinistro può avere una sola perizia (relazione 1-1)
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private Assessment assessment;

    public Claim() {
    }

    public Claim(LocalDateTime date, String place, String description, ClaimState state,
                 List<Vehicle> vehicleInvolved, List<User> userInvolved,
                 Assessment assessment) {
        this.date = date;
        this.place = place;
        this.description = description;
        this.state = state;
        this.vehicleInvolved = vehicleInvolved;
        this.userInvolved = userInvolved;
        this.assessment = assessment;
    }

}
