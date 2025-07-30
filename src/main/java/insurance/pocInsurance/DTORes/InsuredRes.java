package pocInsurance.DTORes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuredRes {

    private Long id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String indirizzo;
    private String username;
}
