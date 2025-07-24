package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.ExpertiseReq;
import pocInsurance.DTORes.ExpertiseRes;
import pocInsurance.Service.ExpertiseService;

import java.util.List;

@RestController
@RequestMapping("/api/expertises")
@RequiredArgsConstructor
@Tag(name = "Expertise", description = "Gestione delle perizie")
public class ExpertiseController {

    private final ExpertiseService expertiseService;

    @PostMapping
    @Operation(summary = "Crea una nuova perizia")
    public ResponseEntity<ExpertiseRes> createExpertise(
            @Valid @RequestBody ExpertiseReq request
    ) {
        return ResponseEntity.ok(expertiseService.createExpertise(request));
    }

    @GetMapping
    @Operation(summary = "Ottieni tutte le perizie associate a un perito")
    public ResponseEntity<List<ExpertiseRes>> getExpertisesByExpert(
            @RequestParam String username
    ) {
        return ResponseEntity.ok(expertiseService.getExpertisesByExpertUsername(username));
    }
}
