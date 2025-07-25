package pocInsurance.Service;

import pocInsurance.DTOReq.InsuranceAgentReq;
import pocInsurance.DTORes.InsuranceAgentRes;
import java.util.List;


public interface InsuranceAgentService {
    InsuranceAgentRes createInsuranceAgent(InsuranceAgentReq req);

    List<InsuranceAgentRes> getAllInsuranceAgents();

    InsuranceAgentRes getInsuranceAgentById(Long id);

    InsuranceAgentRes getAgentByUsername(String username);
}