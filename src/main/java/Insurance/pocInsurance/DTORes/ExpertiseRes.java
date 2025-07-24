package pocInsurance.DTORes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExpertiseRes {

    @Schema(description = "ID della perizia", example = "10")
    private Long id;

    @Schema(description = "Descrizione", example = "Danni lievi al paraurti anteriore")
    private String description;

    @Schema(description = "Username del perito", example = "perito123")
    private String expertUsername;

    @Schema(description = "ID del sinistro", example = "1")
    private Long claimId;
}
