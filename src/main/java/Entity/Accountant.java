package Entity;

public class Accountant extends User {
    private String codId;  // codice interno aziendale

    public Accountant() {
        super();
        this.setRole("ACCOUNTANT");
    }

    public Accountant(Long id, String name, String email, String password, String codId) {
        super();
        this.codId = codId;
    }

    // Getter e Setter

    public String getCodIdo() {
        return codId;
    }

    public void setCodId(String codId) {
        this.codId = codId;
    }

}
