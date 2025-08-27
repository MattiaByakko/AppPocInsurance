package pocInsurance.Mapper;

import org.springframework.stereotype.Component;
import pocInsurance.DTORes.CompensationRes;
import pocInsurance.Entity.Compensation;

@Component
public class CompensationMapper {

    public CompensationRes toDto(Compensation compensation) {
        CompensationRes res = new CompensationRes();
        res.setId(compensation.getId());
        res.setImportoStimato(compensation.getImportoStimato());
        res.setMassimale(compensation.getMassimale());
        res.setStato(compensation.getStato().name()); // <-- enum convertito in String
        res.setClaimId(compensation.getClaim().getId());
        res.setAccountantId(compensation.getAccountant().getId());
        return res;
    }
}
