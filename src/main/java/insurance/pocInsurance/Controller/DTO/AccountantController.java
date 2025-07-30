package pocInsurance.Controller.DTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.AccountantReq;
import pocInsurance.DTORes.AccountantRes;
import pocInsurance.Service.AccountantService;

import java.util.List;

@RestController
@RequestMapping("/api/accountants")
@Tag(name = "Accountant Controller", description = "Gestione dei contabili e delle relative operazioni")
public class AccountantController {

    private final AccountantService accountantService;

    public AccountantController(AccountantService accountantService) {
        this.accountantService = accountantService;
    }

    @Operation(summary = "Crea un nuovo contabile")
    @PostMapping
    public ResponseEntity<AccountantRes> createAccountant(@RequestBody AccountantReq request) {
        AccountantRes created = accountantService.createAccountant(request);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Recupera tutti i contabili")
    @GetMapping
    public ResponseEntity<List<AccountantRes>> getAllAccountants() {
        return ResponseEntity.ok(accountantService.getAllAccountants());
    }
}
