package pocInsurance.Service;

import pocInsurance.DTOReq.ExpertiseReq;
import pocInsurance.DTORes.ExpertiseRes;

import java.util.List;

public interface ExpertiseService {

    ExpertiseRes createExpertise(ExpertiseReq request);

    ExpertiseRes getExpertiseById(Long id);

    ExpertiseRes getExpertiseByClaimId(Long claimId);

    List<ExpertiseRes> getExpertisesByExpertUsername(String username);

    ExpertiseRes updateExpertise(Long id, ExpertiseReq request);

    void deleteExpertise(Long id);

    List<ExpertiseRes> getAllExpertises();
}
