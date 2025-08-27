package pocInsurance.Controller.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;
import pocInsurance.Entity.State;
import pocInsurance.Service.ClaimService;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    // --- Ottieni tutti i claim ---
    @GetMapping
    public List<ClaimRes> getAllClaims() {
        return claimService.getAllClaims();
    }

    // --- Ottieni un singolo claim per ID ---
    @GetMapping("/{id}")
    public ClaimRes getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    // --- Ottieni claim di un assicurato ---
    @GetMapping("/insured/{insuredId}")
    public List<ClaimRes> getClaimsByInsured(@PathVariable Long insuredId) {
        return claimService.getClaimsByInsuredId(insuredId);
    }

    // --- Crea un nuovo claim ---
    @PostMapping
    public ClaimRes createClaim(@RequestBody ClaimReq request) {
        return claimService.createClaim(request);
    }

    // --- Aggiorna tutti i campi di un claim esistente ---
    @PutMapping("/{id}")
    public ClaimRes updateClaim(@PathVariable Long id, @RequestBody ClaimReq request) {
        return claimService.updateClaim(id, request);
    }

    // --- Aggiorna solo lo stato di un claim ---
    @PatchMapping("/{id}/state")
    public ClaimRes updateClaimState(@PathVariable Long id, @RequestParam State nuovoStato) {
        return claimService.updateClaimState(id, nuovoStato);
    }
}
