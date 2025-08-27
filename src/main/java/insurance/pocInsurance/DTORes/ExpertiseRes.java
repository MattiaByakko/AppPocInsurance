package pocInsurance.DTORes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertiseRes {

    private Long id;
    private String descrizione;
    private LocalDate dataCreazione;
    private Long claimId;
    private Long expertId;
    private String expertName;

}
