package pocInsurance.DTORes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpertPRes {

    @Schema(description = "ID del perito", example = "1")
    private Long id;

    @Schema(description = "Nome del perito", example = "Mario")
    private String nome;

    @Schema(description = "Cognome del perito", example = "Rossi")
    private String cognome;

    @Schema(description = "Codice fiscale", example = "RSSMRA80A01H501Z")
    private String codiceFiscale;

    @Schema(description = "Zona di competenza", example = "Lombardia")
    private String zonaDiCompetenza;

    @Schema(description = "Username collegato all'utente", example = "expert123")
    private String username;
}
