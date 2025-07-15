package Entity;

public class Vehicle {
    private Long id;
    private String lPlate;
    private String brand;
    private String model;
    private int imYear;
    private String type;
    private String frame;
    private User owner;

    public Vehicle() {
    }

    public Vehicle(Long id, String lPlate, String brand, String model,
                   int imYear, String type, String frame, User owner) {
        this.id = id;
        this.lPlate = lPlate;
        this.brand = brand;
        this.model = model;
        this.imYear = imYear;
        this.type = type;
        this.frame = frame;
        this.owner = owner;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getlPlate() {
        return lPlate;
    }

    public void setlPlate(String lPlate) {
        this.lPlate = lPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getimYear() {
        return imYear;
    }

    public void setimYear(int imYear) {
        this.imYear = imYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
