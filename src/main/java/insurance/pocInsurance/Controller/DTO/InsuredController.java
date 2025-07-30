package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.InsuredReq;
import pocInsurance.DTORes.InsuredRes;
import pocInsurance.Service.InsuredService;

import java.util.List;

@RestController
@RequestMapping("/api/insured")
@Tag(name = "Insured", description = "Operazioni per la gestione degli assicurati")
public class InsuredController {

    private final InsuredService insuredService;

    public InsuredController(InsuredService insuredService) {
        this.insuredService = insuredService;
    }

    @Operation(summary = "Crea un nuovo assicurato (con utente associato)")
    @PostMapping
    public ResponseEntity<InsuredRes> createInsured(@RequestBody InsuredReq request) {
        InsuredRes response = insuredService.createInsured(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Recupera tutti gli assicurati")
    @GetMapping
    public ResponseEntity<List<InsuredRes>> getAllInsured() {
        List<InsuredRes> list = insuredService.getAllInsured();
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Recupera un assicurato per ID")
    @GetMapping("/{id}")
    public ResponseEntity<InsuredRes> getInsuredById(@PathVariable Long id) {
        InsuredRes response = insuredService.getInsuredById(id);
        return ResponseEntity.ok(response);
    }
}
