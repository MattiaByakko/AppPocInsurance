package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "DTO per la creazione/modifica di un Insurance Agent")
@Data

public class InsuranceAgentReq {


    @Schema(description = "Nome dell'agente", example = "Mario")
    private String firstName;

    @Schema(description = "Cognome dell'agente", example = "Rossi")
    private String lastName;

    @Schema(description = "Email dell'agente", example = "mario.rossi@email.com")
    private String email;

    @Schema(description = "Numero di telefono", example = "+39 333 1234567")
    private String phoneNumber;

    @Schema(description = "Username dell'utente associato", example = "marioRossi89")
    private String username; // Serve per legare l'agente a uno User

    private String password;
}


