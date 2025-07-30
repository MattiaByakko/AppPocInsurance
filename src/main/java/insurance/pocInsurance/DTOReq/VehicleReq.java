package pocInsurance.DTOReq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "DTO di richiesta per la creazione di un veicolo")
@Data
public class VehicleReq {

    @Schema(description = "Targa del veicolo", example = "AB123CD")
    private String targa;

    @Schema(description = "Marca del veicolo", example = "Fiat")
    private String marca;

    @Schema(description = "Modello del veicolo", example = "Panda")
    private String modello;

    @Schema(description = "Anno di immatricolazione", example = "2020")
    private int anno;

    @Schema(description = "ID dell'assicurato (Insured)")
    private Long insuredId;

    @Schema(description = "ID della controparte (Counterpart)")
    private Long counterpartId;
}
