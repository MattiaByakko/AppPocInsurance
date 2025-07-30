package pocInsurance.DTORes;

public class ClaimRes {
    private Long id;
    private String descrizione;
    private Long expertId;
    private Long accountantId;
    private Long zone;

    // Costruttori
    public ClaimRes(Long id, String descrizione, String zone, Long expertId, Long accountantId) {}

    public ClaimRes(Long id, String descrizione, Long expertId, Long accountantId) {
        this.id = id;
        this.descrizione = descrizione;
        this.expertId = expertId;
        this.accountantId = accountantId;
        this.zone=zone;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public Long getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(Long accountantId) {
        this.accountantId = accountantId;
    }

    public Long getZone() {
        return zone;
    }

    public void setZone(Long zone) {
        this.zone = zone;
    }
}
