package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.InsuranceAgentReq;
import pocInsurance.DTORes.InsuranceAgentRes;
import pocInsurance.Service.InsuranceAgentService;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-agents")
@RequiredArgsConstructor
public class InsuranceAgentController {

    private final InsuranceAgentService insuranceAgentService;

    @Operation(summary = "Crea un nuovo agente assicurativo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agente creato con successo"),
            @ApiResponse(responseCode = "400", description = "Dati non validi")
    })
    @PostMapping
    public ResponseEntity<InsuranceAgentRes> createAgent(@RequestBody InsuranceAgentReq request) {
        InsuranceAgentRes res = insuranceAgentService.createInsuranceAgent(request);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "Restituisce tutti gli agenti assicurativi")
    @GetMapping
    public ResponseEntity<List<InsuranceAgentRes>> getAllAgents() {
        return ResponseEntity.ok(insuranceAgentService.getAllInsuranceAgents());
    }

    @Operation(summary = "Trova un agente tramite username dell'utente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agente trovato"),
            @ApiResponse(responseCode = "404", description = "Nessun agente trovato per username fornito")
    })
    @GetMapping("/by-username")
    public ResponseEntity<InsuranceAgentRes> getByUsername(@RequestParam String username) {
        return ResponseEntity.ok(insuranceAgentService.getAgentByUsername(username));
    }
}
