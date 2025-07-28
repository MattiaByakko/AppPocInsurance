package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompensationReq {

    @Schema(description = "ID del sinistro associato", example = "1")
    private Long claimId;

    @Schema(description = "Username del contabile che crea la compensazione", example = "accountant1")
    private String accountantUsername;

    @Schema(description = "Importo stimato del risarcimento", example = "1200.50")
    private BigDecimal importoStimato;

    @Schema(description = "Massimale previsto dal contratto", example = "5000.00")
    private BigDecimal massimale;
}
