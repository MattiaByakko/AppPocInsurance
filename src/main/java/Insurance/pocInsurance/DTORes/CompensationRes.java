package pocInsurance.DTORes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import pocInsurance.Entity.CompensationState;

import java.math.BigDecimal;

@Data
@Builder
public class CompensationRes {

    @Schema(description = "ID della compensazione", example = "1")
    private Long id;

    @Schema(description = "Importo stimato", example = "1200.50")
    private BigDecimal importoStimato;

    @Schema(description = "Massimale", example = "5000.00")
    private BigDecimal massimale;

    @Schema(description = "Stato della compensazione", example = "IN_ATTESA")
    private CompensationState stato;

    @Schema(description = "ID del sinistro associato", example = "1")
    private Long claimId;

    @Schema(description = "ID dell'accountant che ha creato la compensazione", example = "3")
    private Long accountantId;
}
