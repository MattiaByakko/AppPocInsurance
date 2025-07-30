package pocInsurance.Service;

import pocInsurance.DTOReq.ExpertPReq;
import pocInsurance.DTORes.ExpertPRes;

import java.util.List;

public interface ExpertPService {

    ExpertPRes createExpert(ExpertPReq expertPReq);

    ExpertPRes getExpertById(Long id);

    List<ExpertPRes> getAllExperts();

    void deleteExpert(Long id);

    List<ExpertPRes> getExpertsByZona(String zona);

}
