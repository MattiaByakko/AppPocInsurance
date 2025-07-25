package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.PolicyReq;
import pocInsurance.DTORes.PolicyRes;
import pocInsurance.Service.PolicyService;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
@Tag(name = "Policy", description = "Gestione delle polizze assicurative")
public class PolicyController {

    private final PolicyService policyService;

    @Operation(summary = "Crea una nuova polizza")
    @ApiResponse(responseCode = "200", description = "Polizza creata con successo")
    @PostMapping
    public ResponseEntity<PolicyRes> createPolicy(
            @RequestBody PolicyReq request) {
        return ResponseEntity.ok(policyService.createPolicy(request));
    }

    @Operation(summary = "Recupera tutte le polizze")
    @ApiResponse(responseCode = "200", description = "Lista di polizze recuperata")
    @GetMapping
    public ResponseEntity<List<PolicyRes>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @Operation(summary = "Recupera una polizza per ID")
    @ApiResponse(responseCode = "200", description = "Polizza trovata")
    @GetMapping("/{id}")
    public ResponseEntity<PolicyRes> getPolicyById(
            @Parameter(description = "ID della polizza") @PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @Operation(summary = "Recupera tutte le polizze associate a un utente")
    @ApiResponse(responseCode = "200", description = "Polizze trovate")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PolicyRes>> getPoliciesByUserId(
            @Parameter(description = "ID dell'utente") @PathVariable Long userId) {
        return ResponseEntity.ok(policyService.getPoliciesByUserId(userId));
    }

    @Operation(summary = "Recupera la polizza associata a un veicolo")
    @ApiResponse(responseCode = "200", description = "Polizza trovata")
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<PolicyRes> getPolicyByVehicleId(
            @Parameter(description = "ID del veicolo") @PathVariable Long vehicleId) {
        return ResponseEntity.ok(policyService.getPolicyByVehicleId(vehicleId));
    }
}
