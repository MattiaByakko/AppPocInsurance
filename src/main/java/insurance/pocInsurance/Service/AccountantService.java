package pocInsurance.Service;

import pocInsurance.DTOReq.AccountantReq;
import pocInsurance.DTORes.AccountantRes;

import java.util.List;

public interface AccountantService {
    AccountantRes createAccountant(AccountantReq request);
    List<AccountantRes> getAllAccountants();
}
