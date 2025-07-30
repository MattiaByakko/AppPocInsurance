package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.ExpertPReq;
import pocInsurance.DTORes.ExpertPRes;
import pocInsurance.Service.ExpertPService;

import java.util.List;

@RestController
@RequestMapping("/api/experts")
@RequiredArgsConstructor
@Tag(name = "ExpertP", description = "Gestione dei periti assicurativi")
public class ExpertPController {

    private final ExpertPService expertPService;

    @Operation(summary = "Crea un nuovo perito")
    @PostMapping
    public ResponseEntity<ExpertPRes> createExpert(@RequestBody ExpertPReq request) {
        return ResponseEntity.ok(expertPService.createExpert(request));
    }

    @Operation(summary = "Recupera tutti i periti")
    @GetMapping
    public ResponseEntity<List<ExpertPRes>> getAllExperts() {
        return ResponseEntity.ok(expertPService.getAllExperts());
    }

    @Operation(summary = "Recupera un perito per ID")
    @GetMapping("/{id}")
    public ResponseEntity<ExpertPRes> getExpertById(@PathVariable Long id) {
        return ResponseEntity.ok(expertPService.getExpertById(id));
    }

    @Operation(summary = "Recupera un perito tramite User ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ExpertPRes> getExpertByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(expertPService.getExpertById(userId));
    }

    @Operation(summary = "Recupera tutti i periti per zona di competenza")
    @GetMapping("/zona")
    public ResponseEntity<List<ExpertPRes>> getExpertsByZona(@RequestParam String zona) {
        return ResponseEntity.ok(expertPService.getExpertsByZona(zona));
    }
}
