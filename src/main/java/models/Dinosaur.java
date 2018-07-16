package models;

import db.DBDino;
import db.DBPaddock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dinosaurs")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Dinosaur {

    private int id;
    private Species species;
    private Boolean inCaptivity;
    private int belly;
    private Paddock paddock;

    public Dinosaur(Species species, Boolean inCaptivity) {
        this.species = species;
        this.inCaptivity = inCaptivity;
        this.belly = belly;
    }

    public Dinosaur() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(value = EnumType.STRING)
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Column(name="captivity")
    public Boolean getInCaptivity() {
        return inCaptivity;
    }

    public void setInCaptivity(Boolean inCaptivity) {
        this.inCaptivity = inCaptivity;
    }

    @Column(name="belly")
    public int getBelly() {
        return belly;
    }

    public void setBelly(int belly) {
        this.belly = belly;
    }

    @ManyToOne
    @JoinColumn(name = "paddock_id", nullable = false)
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {

        this.paddock = paddock;
    }

    public void assignPaddock(Paddock paddock) {
        List<Dinosaur> dinosaurs = DBPaddock.getDinosInPaddock(paddock);

        if (dinosaurs.get(0).getClass() == this.getClass()) {
            this.paddock = paddock;
        }
    }
}
