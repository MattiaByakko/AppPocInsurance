package pocInsurance.DTORes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "DTO risposta per una polizza assicurativa")
@Data
@Builder
public class PolicyRes {

    private Long id;

    @Schema(description = "Numero identificativo della polizza", example = "POL12345678")
    private String numeroPolizza;

    @Schema(description = "Data di inizio della polizza", example = "2025-01-01")
    private String dataInizio;

    @Schema(description = "Data di fine della polizza", example = "2025-12-31")
    private String dataFine;

    @Schema(description = "ID utente associato", example = "1")
    private Long userId;

    @Schema(description = "ID veicolo associato", example = "2")
    private Long vehicleId;
}
