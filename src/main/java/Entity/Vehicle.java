package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String lPlate;

    private String brand;
    private String model;

    @Column(name = "immatriculation_year")
    private int imYear;

    private String type;
    private String frame;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    public Vehicle() {}

    public Vehicle(String lPlate, String brand, String model, int imYear, String type, String frame, Person owner) {
        this.lPlate = lPlate;
        this.brand = brand;
        this.model = model;
        this.imYear = imYear;
        this.type = type;
        this.frame = frame;
        this.owner = owner;
    }

    // Getters and setters
    public Long getId() {
        return id;
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

    public int getImYear() {
        return imYear;
    }

    public void setImYear(int imYear) {
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
