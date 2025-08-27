package pocInsurance.DTORes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.Objects;
import pocInsurance.Entity.CompensationState;

@JsonPropertyOrder({
        "id",
        "importoStimato",
        "massimale",
        "stato",
        "claimId",
        "accountantId"
})
public class CompensationRes {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("importoStimato")
    private BigDecimal importoStimato;

    @JsonProperty("massimale")
    private BigDecimal massimale;

    @JsonProperty("stato")
    private String stato;

    @JsonProperty("claimId")
    private Long claimId;

    @JsonProperty("accountantId")
    private Long accountantId;

    // Costruttore pubblico completo
    public CompensationRes(Long id, BigDecimal importoStimato, BigDecimal massimale,
                           String stato, Long claimId, Long accountantId) {
        this.id = id;
        this.importoStimato = importoStimato;
        this.massimale = massimale;
        this.stato = stato;
        this.claimId = claimId;
        this.accountantId = accountantId;
    }

    // Costruttore vuoto
    public CompensationRes() {}

    // --- Getter & Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getImportoStimato() { return importoStimato; }
    public void setImportoStimato(BigDecimal importoStimato) { this.importoStimato = importoStimato; }

    public BigDecimal getMassimale() { return massimale; }
    public void setMassimale(BigDecimal massimale) { this.massimale = massimale; }

    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }

    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }

    public Long getAccountantId() { return accountantId; }
    public void setAccountantId(Long accountantId) { this.accountantId = accountantId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompensationRes that = (CompensationRes) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(importoStimato, that.importoStimato) &&
                Objects.equals(massimale, that.massimale) &&
                Objects.equals(stato, that.stato) &&
                Objects.equals(claimId, that.claimId) &&
                Objects.equals(accountantId, that.accountantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, importoStimato, massimale, stato, claimId, accountantId);
    }

    @Override
    public String toString() {
        return "CompensationRes{" +
                "id=" + id +
                ", importoStimato=" + importoStimato +
                ", massimale=" + massimale +
                ", stato='" + stato + '\'' +
                ", claimId=" + claimId +
                ", accountantId=" + accountantId +
                '}';
    }
}
