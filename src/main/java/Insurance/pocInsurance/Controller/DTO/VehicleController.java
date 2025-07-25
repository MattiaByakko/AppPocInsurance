package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.VehicleReq;
import pocInsurance.DTORes.VehicleRes;
import pocInsurance.Service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
@Tag(name = "Vehicle Controller", description = "Gestione dei veicoli")
public class VehicleController {

    private final VehicleService vehicleService;

    @Operation(summary = "Crea un nuovo veicolo")
    @PostMapping
    public ResponseEntity<VehicleRes> createVehicle(@RequestBody VehicleReq request) {
        return new ResponseEntity<>(vehicleService.createVehicle(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Ottiene tutti i veicoli")
    @GetMapping
    public ResponseEntity<List<VehicleRes>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @Operation(summary = "Ottiene un veicolo per ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleRes> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @Operation(summary = "Ottiene veicoli associati a un insured")
    @GetMapping("/by-insured/{insuredId}")
    public ResponseEntity<List<VehicleRes>> getVehiclesByInsured(@PathVariable Long insuredId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByInsuredId(insuredId));
    }

    @Operation(summary = "Ottiene veicoli associati a una controparte")
    @GetMapping("/by-controparte/{controparteId}")
    public ResponseEntity<List<VehicleRes>> getVehiclesByControparte(@PathVariable Long controparteId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByCounterpartId(controparteId));
    }
}
