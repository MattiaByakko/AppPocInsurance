package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.CounterpartReq;
import pocInsurance.DTORes.CounterpartRes;
import pocInsurance.Service.CounterpartService;

import java.util.List;

@RestController
@RequestMapping("/api/counterparts")
@RequiredArgsConstructor
@Tag(name = "Counterpart Controller", description = "Gestione delle controparti")
public class CounterpartController {

    private final CounterpartService counterpartService;

    @PostMapping
    @Operation(summary = "Crea una nuova controparte")
    public ResponseEntity<CounterpartRes> createCounterpart(@RequestBody CounterpartReq request) {
        return ResponseEntity.ok(counterpartService.createCounterpart(request));
    }

    @GetMapping
    @Operation(summary = "Recupera tutte le controparti")
    public ResponseEntity<List<CounterpartRes>> getAllCounterparts() {
        return ResponseEntity.ok(counterpartService.getAllCounterparts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera una controparte tramite ID")
    public ResponseEntity<CounterpartRes> getCounterpartById(@PathVariable Long id) {
        return ResponseEntity.ok(counterpartService.getCounterpartById(id));
    }
}
