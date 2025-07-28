package pocInsurance.Service;

import pocInsurance.DTOReq.InsuredReq;
import pocInsurance.DTORes.InsuredRes;

import java.util.List;

public interface InsuredService {
    InsuredRes createInsured(InsuredReq request);
    List<InsuredRes> getAllInsured();
    InsuredRes getInsuredById(Long id);
}
