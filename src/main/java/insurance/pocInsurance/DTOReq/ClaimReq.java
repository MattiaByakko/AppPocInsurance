package pocInsurance.DTOReq;


public class ClaimReq {

    private String descrizione;
    private String zone;
    private String dataEvento; // formato ISO yyyy-MM-dd

    private Long insuredId;
    private Long vehicleId;
    private Long policyId;

    private Long expertId;
    private Long accountantId;

    private Long counterpartId; // se esiste già
    private String counterpartNome;
    private String counterpartCognome;
    private String counterpartCodiceFiscale;
    private String counterpartIndirizzo;

    private String state; // valore enum State come stringa

    public ClaimReq() {}

    // --- Getters & Setters ---
    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getDataEvento() { return dataEvento; }
    public void setDataEvento(String dataEvento) { this.dataEvento = dataEvento; }

    public Long getInsuredId() { return insuredId; }
    public void setInsuredId(Long insuredId) { this.insuredId = insuredId; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public Long getPolicyId() { return policyId; }
    public void setPolicyId(Long policyId) { this.policyId = policyId; }

    public Long getExpertId() { return expertId; }
    public void setExpertId(Long expertId) { this.expertId = expertId; }

    public Long getAccountantId() { return accountantId; }
    public void setAccountantId(Long accountantId) { this.accountantId = accountantId; }

    public Long getCounterpartId() { return counterpartId; }
    public void setCounterpartId(Long counterpartId) { this.counterpartId = counterpartId; }

    public String getCounterpartNome() { return counterpartNome; }
    public void setCounterpartNome(String counterpartNome) { this.counterpartNome = counterpartNome; }

    public String getCounterpartCognome() { return counterpartCognome; }
    public void setCounterpartCognome(String counterpartCognome) { this.counterpartCognome = counterpartCognome; }

    public String getCounterpartCodiceFiscale() { return counterpartCodiceFiscale; }
    public void setCounterpartCodiceFiscale(String counterpartCodiceFiscale) { this.counterpartCodiceFiscale = counterpartCodiceFiscale; }

    public String getCounterpartIndirizzo() { return counterpartIndirizzo; }
    public void setCounterpartIndirizzo(String counterpartIndirizzo) { this.counterpartIndirizzo = counterpartIndirizzo; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
