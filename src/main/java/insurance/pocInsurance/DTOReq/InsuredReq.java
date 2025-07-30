package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class InsuredReq {

    @Schema(description = "Nome dell'assicurato", example = "Mario")
    private String nome;

    @Schema(description = "Cognome dell'assicurato", example = "Rossi")
    private String cognome;

    @Schema(description = "Codice fiscale", example = "RSSMRA80A01H501U")
    private String codiceFiscale;

    @Schema(description = "Indirizzo di residenza", example = "Via Roma 123")
    private String indirizzo;

    @Schema(description = "Username per il login", example = "mario.rossi")
    private String username;

    @Schema(description = "Password per il login", example = "password123")
    private String password;

    @Schema(description = "Ruolo utente", example = "INSURED")
    private String ruolo;
}
