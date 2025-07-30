package pocInsurance.DTORes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountantRes {
    private Long id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String username;
}
