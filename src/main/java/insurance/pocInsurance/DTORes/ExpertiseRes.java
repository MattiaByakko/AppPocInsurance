package pocInsurance.DTORes;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExpertiseRes {
    private Long id;
    private String description;
    private LocalDate dataCreazione;
    private Long claimId;
    private Long expertId;
}
