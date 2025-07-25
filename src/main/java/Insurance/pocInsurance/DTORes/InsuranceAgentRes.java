package pocInsurance.DTORes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "DTO di risposta per un Insurance Agent")
@Data
@Builder
public class InsuranceAgentRes {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String username; // preso da user associato
}
