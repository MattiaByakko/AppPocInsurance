package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AccountantReq {

    @Schema(description = "Nome del contabile", example = "Mario")
    private String nome;

    @Schema(description = "Cognome del contabile", example = "Rossi")
    private String cognome;

    @Schema(description = "Codice fiscale univoco", example = "RSSMRA80A01H501Z")
    private String codiceFiscale;

    // Dati per creare anche l'utente
    @Schema(description = "Username per il login", example = "mario.rossi")
    private String username;

    @Schema(description = "Password per il login", example = "securePassword123")
    private String password;

    @Schema(description = "Ruolo dell'utente", example = "ACCOUNTANT")
    private String role;
}
