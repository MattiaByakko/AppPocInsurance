package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExpertiseReq {

    @Schema(description = "ID del sinistro", example = "1")
    private Long claimId;

    @Schema(description = "Username del perito", example = "perito123")
    private String expertUsername;

    @Schema(description = "Descrizione della perizia", example = "Danni lievi al paraurti anteriore")
    private String description;
}
