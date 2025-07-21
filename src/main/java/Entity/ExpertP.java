package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "experts")
public class ExpertP extends User {

    private String areaCompetenza;

    public ExpertP() {
        super();
    }

    public ExpertP(String nome, String cognome, String email, String password, boolean client,
                   String areaCompetenza) {
        super(nome, cognome, email, password, client);
        this.areaCompetenza = areaCompetenza;
    }

    public String getAreaCompetenza() {
        return areaCompetenza;
    }

    public void setAreaCompetenza(String areaCompetenza) {
        this.areaCompetenza = areaCompetenza;
    }

}
