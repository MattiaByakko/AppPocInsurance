package pocInsurance.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String targa;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modello;

    @Column(nullable = false)
    private int anno;

    @OneToOne(mappedBy = "vehicle")
    private Policy policy;

    @ManyToOne
    @JoinColumn(name = "counterpart_id")
    private Counterpart controparte;

    @ManyToOne
    @JoinColumn(name = "insured_id")
    private Insured insured;


    public Vehicle() {
    }

    public Vehicle(String targa, String marca, String modello, int anno) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    // Getter e Setter

    public Counterpart getControparte() {
        return controparte;
    }

    public void setControparte(Counterpart controparte) {
        this.controparte = controparte;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
