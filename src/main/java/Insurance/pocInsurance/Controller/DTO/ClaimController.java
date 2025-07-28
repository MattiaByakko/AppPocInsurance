package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;
import pocInsurance.Service.ClaimService;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Claims", description = "Gestione dei sinistri assicurativi")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    @Operation(summary = "Crea un nuovo sinistro")
    public ResponseEntity<ClaimRes> createClaim(@RequestBody ClaimReq request) {
        return ResponseEntity.ok(claimService.createClaim(request));
    }

    @GetMapping
    @Operation(summary = "Recupera tutti i sinistri")
    public ResponseEntity<List<ClaimRes>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera un sinistro tramite ID")
    public ResponseEntity<ClaimRes> getClaimById(@PathVariable Long id) {
        return ResponseEntity.ok(claimService.getClaimById(id));
    }

    @GetMapping("/insured/{insuredId}")
    @Operation(summary = "Recupera i sinistri di un assicurato specifico")
    public ResponseEntity<List<ClaimRes>> getClaimsByInsured(@PathVariable Long insuredId) {
        return ResponseEntity.ok(claimService.getClaimsByInsuredId(insuredId));
    }

    @PutMapping("/{id}/state")
    @Operation(summary = "Aggiorna lo stato del sinistro")
    public ResponseEntity<ClaimRes> updateClaimState(@PathVariable Long id, @RequestParam String state) {
        return ResponseEntity.ok(claimService.updateClaimState(id, state));
    }
}
