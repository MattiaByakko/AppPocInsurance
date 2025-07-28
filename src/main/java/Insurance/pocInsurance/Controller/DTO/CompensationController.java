package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.CompensationReq;
import pocInsurance.DTORes.CompensationRes;
import pocInsurance.Service.CompensationService;

import java.util.List;

@RestController
@RequestMapping("/api/compensations")
@RequiredArgsConstructor
@Tag(name = "Compensation", description = "Gestione delle compensazioni")
public class CompensationController {

    private final CompensationService compensationService;

    @PostMapping
    @Operation(summary = "Crea una nuova compensazione")
    public ResponseEntity<CompensationRes> createCompensation(@RequestBody CompensationReq request) {
        return ResponseEntity.ok(compensationService.createCompensation(request));
    }

    @GetMapping
    @Operation(summary = "Recupera tutte le compensazioni")
    public ResponseEntity<List<CompensationRes>> getAll() {
        return ResponseEntity.ok(compensationService.getAllCompensations());
    }

    @GetMapping("/by-claim/{claimId}")
    @Operation(summary = "Recupera una compensazione tramite l'ID del sinistro")
    public ResponseEntity<CompensationRes> getByClaimId(@PathVariable Long claimId) {
        return ResponseEntity.ok(compensationService.getCompensationByClaimId(claimId));
    }
}
