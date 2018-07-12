package models;

import java.util.ArrayList;
import java.util.List;

public class Paddock {

    private int id;
    private int number;
    private int integrity;
    private List<Dinosaur> dinosaurs;

    public Paddock() {
    }

    public Paddock(int number) {
        this.number = number;
        this.integrity = 100;
        this.dinosaurs = new ArrayList<Dinosaur>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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

    public int getIntegrity() {
        return integrity;
    }

    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }

    public void rampage(){
        for (Dinosaur dino : this.dinosaurs){
            this.integrity -= dino.getSpecies().getAggression();
        }
    }
}
