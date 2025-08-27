package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.ExpertiseReq;
import pocInsurance.DTORes.ExpertiseRes;
import pocInsurance.Service.ExpertiseService;

import java.util.List;

@RestController
@RequestMapping("/api/expertise")
@RequiredArgsConstructor
@Tag(name = "Expertise", description = "Gestione delle perizie")
public class ExpertiseController {

    private final ExpertiseService expertiseService;

    @PostMapping
    @Operation(summary = "Crea una nuova perizia")
    public ResponseEntity<ExpertiseRes> createExpertise(@RequestBody ExpertiseReq request) {
        ExpertiseRes res = expertiseService.createExpertise(request);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ottiene una perizia tramite ID")
    public ResponseEntity<ExpertiseRes> getExpertiseById(@PathVariable Long id) {
        return ResponseEntity.ok(expertiseService.getExpertiseById(id));
    }

    @GetMapping("/all")
    @Operation(summary = "Ottiene tutte le perizie")
    public ResponseEntity<List<ExpertiseRes>> getAllExpertises() {
        return ResponseEntity.ok(expertiseService.getAllExpertises());
    }

    @GetMapping("/expert/{username}")
    @Operation(summary = "Ottiene tutte le perizie create da un perito (username)")
    public ResponseEntity<List<ExpertiseRes>> getExpertisesByExpertUsername(@PathVariable String username) {
        return ResponseEntity.ok(expertiseService.getExpertisesByExpertUsername(username));
    }

    @GetMapping("/claim/{claimId}")
    @Operation(summary = "Ottiene una perizia tramite claim ID")
    public ResponseEntity<ExpertiseRes> getExpertiseByClaimId(@PathVariable Long claimId) {
        return ResponseEntity.ok(expertiseService.getExpertiseByClaimId(claimId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aggiorna una perizia esistente")
    public ResponseEntity<ExpertiseRes> updateExpertise(@PathVariable Long id, @RequestBody ExpertiseReq request) {
        return ResponseEntity.ok(expertiseService.updateExpertise(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una perizia")
    public ResponseEntity<Void> deleteExpertise(@PathVariable Long id) {
        expertiseService.deleteExpertise(id);
        return ResponseEntity.noContent().build();
    }
}
