package pocInsurance.Service;

import pocInsurance.DTOReq.CompensationReq;
import pocInsurance.DTORes.CompensationRes;

import java.util.List;

public interface CompensationService {

    CompensationRes createCompensation(CompensationReq request);

    List<CompensationRes> getAllCompensations();

    CompensationRes getCompensationById(Long id);

    CompensationRes getCompensationByClaimId(Long claimId);


}
