package pocInsurance.Mapper;

import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;
import pocInsurance.Entity.Claim;
import pocInsurance.Entity.Accountant;
import pocInsurance.Entity.ExpertP;

public class ClaimMapper {

    public static ClaimRes toClaimRes(Claim claim) {
        Long expertId = claim.getExpert() != null ? claim.getExpert().getId() : null;
        Long accountantId = claim.getAccountant() != null ? claim.getAccountant().getId() : null;

        return new ClaimRes(
                claim.getId(),
                claim.getDescrizione(),
                expertId,
                accountantId
        );
    }

    public static Claim toClaim(ClaimReq req) {
        Claim claim = new Claim();
        claim.setDescrizione(req.getDescrizione());
        return claim;
    }
}
