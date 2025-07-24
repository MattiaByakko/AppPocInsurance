package pocInsurance.Service;

import pocInsurance.DTOReq.ExpertiseReq;
import pocInsurance.DTORes.ExpertiseRes;

import java.util.List;

public interface ExpertiseService {
    ExpertiseRes createExpertise(ExpertiseReq expertiseReq);
    List<ExpertiseRes> getExpertisesByExpertUsername(String username);
}
