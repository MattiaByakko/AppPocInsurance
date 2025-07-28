package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CounterpartReq {

    @Schema(description = "Nome della controparte", example = "Mario")
    @NotBlank
    private String nome;

    @Schema(description = "Cognome della controparte", example = "Rossi")
    @NotBlank
    private String cognome;

    @Schema(description = "Codice fiscale", example = "RSSMRA80A01H501U")
    @NotBlank
    private String codiceFiscale;

    @Schema(description = "Indirizzo di residenza", example = "Via Roma 10, Milano")
    @NotBlank
    private String indirizzo;
}
