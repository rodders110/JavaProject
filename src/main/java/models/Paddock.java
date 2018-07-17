package models;

import db.DBHelper;
import db.DBPaddock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="paddocks")
public class Paddock {

    private int id;
    private int number;
    private int integrity;
    private Park park;
    private List<Dinosaur> dinosaurs;

    public Paddock() {
    }

    public Paddock(int number) {
        this.number = number;
        this.integrity = 100;
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

    @Column(name="number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @OneToMany(mappedBy = "paddock", fetch = FetchType.LAZY)
    public List<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(List<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }

    public void addDinosaur(Dinosaur dinosaur){
        this.dinosaurs.add(dinosaur);
        }


    public void removeDinosaur(Dinosaur dinosaur){
        this.dinosaurs.remove(dinosaur);
    }

    @Column(name="integrity")
    public int getIntegrity() {
        return integrity;
    }

    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }

    public void rampage(){
        List<Dinosaur> dinosaurs = DBPaddock.getDinosInPaddock(this);
        for (Dinosaur dino : dinosaurs){
            this.integrity -= dino.getSpecies().getAggression();
            DBHelper.update(this);
        }
    }

    @ManyToOne
    @JoinColumn(name="park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

}
