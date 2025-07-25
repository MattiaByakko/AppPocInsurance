package pocInsurance.Service;

import pocInsurance.DTOReq.PolicyReq;
import pocInsurance.DTORes.PolicyRes;

import java.util.List;

public interface PolicyService {
    PolicyRes createPolicy(PolicyReq request);

    PolicyRes getPolicyById(Long id);

    List<PolicyRes> getAllPolicies();

    List<PolicyRes> getPoliciesByUserId(Long userId);

    PolicyRes getPolicyByVehicleId(Long vehicleId);

}
