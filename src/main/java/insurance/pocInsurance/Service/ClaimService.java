package pocInsurance.Service;

import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;
import pocInsurance.Entity.State;

import java.util.List;

public interface ClaimService {
    ClaimRes createClaim(ClaimReq request);
    List<ClaimRes> getAllClaims();
    ClaimRes getClaimById(Long id);
    ClaimRes updateClaimState(Long claimId, State nuovoStato);
    List<ClaimRes> getClaimsByInsuredId(Long insuredId);
}
