package pocInsurance.DTORes;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pocInsurance.DTORes.CompensationRes;
import pocInsurance.DTORes.ExpertiseRes;
import pocInsurance.DTORes.CounterpartRes; // <-- nuovo

@JsonPropertyOrder({
        "id",
        "descrizione",
        "zone",
        "expertId",
        "accountantId",
        "dataEvento",
        "insuredId",
        "insuredName",
        "counterpart",
        "state",
        "expertise",
        "compensation"
})
public class ClaimRes {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("descrizione")
    private String descrizione;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("expertId")
    private Long expertId;

    @JsonProperty("accountantId")
    private Long accountantId;

    @JsonProperty("dataEvento")
    private String dataEvento;

    @JsonProperty("insuredId")
    private Long insuredId;

    @JsonProperty("insuredName")
    private String insuredName;

    @JsonProperty("counterpart")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CounterpartRes counterpart; // <-- aggiunto

    @JsonProperty("state")
    private String state;

    @JsonProperty("expertise")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ExpertiseRes expertise;

    @JsonProperty("compensation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CompensationRes compensation;

    public ClaimRes() {}

    // Getter e setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public Long getExpertId() { return expertId; }
    public void setExpertId(Long expertId) { this.expertId = expertId; }

    public Long getAccountantId() { return accountantId; }
    public void setAccountantId(Long accountantId) { this.accountantId = accountantId; }

    public String getDataEvento() { return dataEvento; }
    public void setDataEvento(String dataEvento) { this.dataEvento = dataEvento; }

    public Long getInsuredId() { return insuredId; }
    public void setInsuredId(Long insuredId) { this.insuredId = insuredId; }

    public String getInsuredName() { return insuredName; }
    public void setInsuredName(String insuredName) { this.insuredName = insuredName; }

    public CounterpartRes getCounterpart() { return counterpart; }
    public void setCounterpart(CounterpartRes counterpart) { this.counterpart = counterpart; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public ExpertiseRes getExpertise() { return expertise; }
    public void setExpertise(ExpertiseRes expertise) { this.expertise = expertise; }

    public CompensationRes getCompensation() { return compensation; }
    public void setCompensation(CompensationRes compensation) { this.compensation = compensation; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimRes claimRes = (ClaimRes) o;
        return Objects.equals(id, claimRes.id) &&
                Objects.equals(descrizione, claimRes.descrizione) &&
                Objects.equals(zone, claimRes.zone) &&
                Objects.equals(expertId, claimRes.expertId) &&
                Objects.equals(accountantId, claimRes.accountantId) &&
                Objects.equals(dataEvento, claimRes.dataEvento) &&
                Objects.equals(insuredId, claimRes.insuredId) &&
                Objects.equals(insuredName, claimRes.insuredName) &&
                Objects.equals(counterpart, claimRes.counterpart) &&
                Objects.equals(state, claimRes.state) &&
                Objects.equals(expertise, claimRes.expertise) &&
                Objects.equals(compensation, claimRes.compensation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descrizione, zone, expertId, accountantId, dataEvento, insuredId, insuredName, counterpart, state, expertise, compensation);
    }

    @Override
    public String toString() {
        return "ClaimRes{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", zone='" + zone + '\'' +
                ", expertId=" + expertId +
                ", accountantId=" + accountantId +
                ", dataEvento='" + dataEvento + '\'' +
                ", insuredId=" + insuredId +
                ", insuredName='" + insuredName + '\'' +
                ", counterpart=" + counterpart +
                ", state='" + state + '\'' +
                ", expertise=" + expertise +
                ", compensation=" + compensation +
                '}';
    }
}
