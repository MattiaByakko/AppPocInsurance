package pocInsurance.Mapper;

import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;
import pocInsurance.DTORes.CompensationRes;
import pocInsurance.DTORes.ExpertiseRes;
import pocInsurance.Entity.Claim;
import pocInsurance.Entity.State;

import java.time.LocalDate;

public class ClaimMapper {

    public static ClaimRes toClaimRes(Claim claim) {
        if (claim == null) return null;

        ClaimRes res = new ClaimRes();
        res.setId(claim.getId());
        res.setDescrizione(claim.getDescrizione());
        res.setZone(claim.getZone());

        if (claim.getExpert() != null) {
            res.setExpertId(claim.getExpert().getId());
        }

        if (claim.getAccountant() != null) {
            res.setAccountantId(claim.getAccountant().getId());
        }

        if (claim.getDataApertura() != null) {
            res.setDataEvento(claim.getDataApertura().toString());
        }

        if (claim.getInsured() != null) {
            res.setInsuredId(claim.getInsured().getId());
            res.setInsuredName(claim.getInsured().getNome() + " " + claim.getInsured().getCognome());
        }

        if (claim.getState() != null) {
            res.setState(claim.getState().name());
        }

        // Expertise completa
        if (claim.getExpertise() != null) {
            ExpertiseRes expertiseRes = new ExpertiseRes(
                    claim.getExpertise().getId(),
                    claim.getExpertise().getDescrizione(),
                    claim.getExpertise().getDataCreazione(),
                    claim.getExpertise().getClaim() != null ? claim.getExpertise().getClaim().getId() : null,
                    claim.getExpertise().getExpert() != null ? claim.getExpertise().getExpert().getId() : null,
                    claim.getExpertise().getExpert() != null ? claim.getExpertise().getExpert().getNome() : null
            );
            res.setExpertise(expertiseRes);
        }

        // Compensation completa
        if (claim.getCompensation() != null) {
            CompensationRes compensationRes = new CompensationRes(
                    claim.getCompensation().getId(),
                    claim.getCompensation().getImportoStimato(),
                    claim.getCompensation().getMassimale(),
                    claim.getCompensation().getStato().name(),
                    claim.getCompensation().getClaim() != null ? claim.getCompensation().getClaim().getId() : null,
                    claim.getCompensation().getAccountant() != null ? claim.getCompensation().getAccountant().getId() : null
            );
            res.setCompensation(compensationRes);
        }

        return res;
    }

    public static Claim toClaim(ClaimReq request) {
        Claim claim = new Claim();
        claim.setDescrizione(request.getDescrizione());
        claim.setZone(request.getZone());
        if (request.getDataEvento() != null) {
            claim.setDataApertura(LocalDate.parse(request.getDataEvento()));
        }
        claim.setState(State.UNDER_INVESTIGATION); // stato iniziale
        return claim;
    }
}
