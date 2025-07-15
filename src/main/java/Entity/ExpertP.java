package Entity;

public class ExpertP extends User {
    private String zone;


    public ExpertP(Long id, String name, String email, String password, String role, String zone) {
        super(id, name, email, "EXPERTP", password, zone);
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}


