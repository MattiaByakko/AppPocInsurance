package pocInsurance.DTORes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CounterpartRes {

    @Schema(description = "ID della controparte", example = "1")
    private Long id;

    @Schema(description = "Nome della controparte", example = "Mario")
    private String nome;

    @Schema(description = "Cognome della controparte", example = "Rossi")
    private String cognome;

    @Schema(description = "Codice fiscale", example = "RSSMRA80A01H501U")
    private String codiceFiscale;

    @Schema(description = "Indirizzo di residenza", example = "Via Roma 10, Milano")
    private String indirizzo;
}
