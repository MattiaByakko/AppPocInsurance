package pocInsurance.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insurance_agents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role = Role.INSURANCE_AGENT;
}
