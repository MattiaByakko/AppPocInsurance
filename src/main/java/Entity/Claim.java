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
    private State state;

    // Un sinistro può coinvolgere più veicoli
    @ManyToMany
    @JoinTable(
            name = "claim_vehicle",
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

    // Più controparti coinvolte (non utenti)
    @ManyToMany
    @JoinTable(
            name = "claim_counterpart",
            joinColumns = @JoinColumn(name = "claim_id"),
            inverseJoinColumns = @JoinColumn(name = "counterpart_id")
    )
    private List<Counterpart> counterparties;

    // Un sinistro può avere una sola perizia (relazione 1-1)
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private Assessment assessment;

    public Claim() {}

    public Claim(LocalDateTime date, String place, String description, State state,
                 List<Vehicle> vehicleInvolved, List<User> userInvolved,
                 List<Counterpart> counterparties, Assessment assessment) {
        this.date = date;
        this.place = place;
        this.description = description;
        this.state = state;
        this.vehicleInvolved = vehicleInvolved;
        this.userInvolved = userInvolved;
        this.counterparties = counterparties;
        this.assessment = assessment;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Vehicle> getVehicleInvolved() {
        return vehicleInvolved;
    }

    public void setVehicleInvolved(List<Vehicle> vehicleInvolved) {
        this.vehicleInvolved = vehicleInvolved;
    }

    public List<User> getUserInvolved() {
        return userInvolved;
    }

    public void setUserInvolved(List<User> userInvolved) {
        this.userInvolved = userInvolved;
    }

    public List<Counterpart> getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(List<Counterpart> counterparties) {
        this.counterparties = counterparties;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }
}
