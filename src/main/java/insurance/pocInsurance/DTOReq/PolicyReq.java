package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "DTO richiesta per creazione polizza")
@Data
public class PolicyReq {

    @Schema(description = "Numero della polizza", example = "POL12345678")
    private String numeroPolizza;

    @Schema(description = "Data di inizio validità (formato yyyy-MM-dd)", example = "2025-01-01")
    private String dataInizio;

    @Schema(description = "Data di fine validità (formato yyyy-MM-dd)", example = "2025-12-31")
    private String dataFine;

    @Schema(description = "ID dell'utente a cui è associata la polizza", example = "1")
    private Long userId;

    @Schema(description = "ID del veicolo assicurato", example = "2")
    private Long vehicleId;
}
