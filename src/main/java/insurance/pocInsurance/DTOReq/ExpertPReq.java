package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExpertPReq {

    @Schema(description = "Nome del perito", example = "Mario")
    private String nome;

    @Schema(description = "Cognome del perito", example = "Rossi")
    private String cognome;

    @Schema(description = "Codice fiscale", example = "RSSMRA80A01H501Z")
    private String codiceFiscale;

    @Schema(description = "Zona di competenza", example = "Lombardia")
    private String zonaDiCompetenza;

    @Schema(description = "Username per l'accesso", example = "expert123")
    private String username;

    @Schema(description = "Password per l'accesso", example = "password123")
    private String password;

    @Schema(description = "Ruolo utente (deve essere 'EXPERT')", example = "EXPERT")
    private String role;

    @Schema(description = "Email del perito", example = "mario.rossi@email.com")
    private String email;  // <<< NUOVO CAMPO
}
