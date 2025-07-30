package pocInsurance.Mapper;

import org.springframework.stereotype.Component;
import pocInsurance.DTORes.CompensationRes;
import pocInsurance.Entity.Compensation;
import pocInsurance.Entity.CompensationState;

@Component
public class CompensationMapper {

    public CompensationRes toDto(Compensation compensation) {
        return CompensationRes.builder()
                .id(compensation.getId())
                .importoStimato(compensation.getImportoStimato())
                .massimale(compensation.getMassimale())
                .stato(CompensationState.valueOf(compensation.getStato().name()))
                .claimId(compensation.getClaim().getId())
                .accountantId(compensation.getAccountant().getId())
                .build();
    }
}