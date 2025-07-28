package pocInsurance.Service;

import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;

import java.util.List;

public interface ClaimService {
    ClaimRes createClaim(ClaimReq request);
    List<ClaimRes> getAllClaims();
    ClaimRes getClaimById(Long id);
}
