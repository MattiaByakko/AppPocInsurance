package pocInsurance.DTORes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "DTO di risposta per un veicolo")
@Data
@Builder
public class VehicleRes {

    private Long id;

    private String targa;

    private String marca;

    private String modello;

    private int anno;

    private Long insuredId;

    private Long counterpartId;

    private Long policyId; // può essere null se non ancora associata

}
