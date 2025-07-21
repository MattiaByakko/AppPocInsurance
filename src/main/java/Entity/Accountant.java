package Entity;

import jakarta.persistence.Entity;

@Entity
public class Accountant extends User {

    private String codId;

    public Accountant() {
        super();
    }

    public Accountant(String nome, String cognome, String email, String password, String codId) {
        super(nome, cognome, email, password);
        this.codId = codId;
    }

    public String getCodId() {
        return codId;
    }

    public void setCodId(String codId) {
        this.codId = codId;
    }
}
