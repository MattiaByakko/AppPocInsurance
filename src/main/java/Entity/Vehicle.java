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
    @JoinColumn(name = "user_owner_id")
    private User userOwner;

    @ManyToOne
    @JoinColumn(name = "counterpart_owner_id")
    private Counterpart counterpartOwner;

    public Vehicle() {}

    public Vehicle(String lPlate, String brand, String model, int imYear, String type, String frame,
                   User userOwner, Counterpart counterpartOwner) {
        this.lPlate = lPlate;
        this.brand = brand;
        this.model = model;
        this.imYear = imYear;
        this.type = type;
        this.frame = frame;
        this.userOwner = userOwner;
        this.counterpartOwner = counterpartOwner;
    }

    public Long getId() {
        return id;
    }

    public String getLPlate() {
        return lPlate;
    }

    public void setLPlate(String lPlate) {
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

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public Counterpart getCounterpartOwner() {
        return counterpartOwner;
    }

    public void setCounterpartOwner(Counterpart counterpartOwner) {
        this.counterpartOwner = counterpartOwner;
    }
}
