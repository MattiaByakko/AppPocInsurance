package pocInsurance.DTORes;

public class ClaimRes {
    private Long id;
    private String descrizione;
    private Long expertId;
    private Long accountantId;

    // Costruttori
    public ClaimRes() {}

    public ClaimRes(Long id, String descrizione, Long expertId, Long accountantId) {
        this.id = id;
        this.descrizione = descrizione;
        this.expertId = expertId;
        this.accountantId = accountantId;
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
}
