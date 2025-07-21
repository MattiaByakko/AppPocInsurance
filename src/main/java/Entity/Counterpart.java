package Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "controparti")
public class Counterpart extends Person {

    private String codiceFiscale;

    private String telefono;

    private String email;

    public Counterpart() {}

    public Counterpart(String nome, String cognome, String codiceFiscale, String telefono, String email) {
        super(nome, cognome);
        this.codiceFiscale = codiceFiscale;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters and setters
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
