package models;

import java.util.ArrayList;

public abstract class Dinosaur {

    private int id;
    private Species species;
    private Boolean inCaptivity;
    private ArrayList<FoodType> belly;

    public Dinosaur(Species species, Boolean inCaptivity) {
        this.species = species;
        this.inCaptivity = inCaptivity;
        this.belly = new ArrayList<FoodType>();
    }

    public Dinosaur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Boolean getInCaptivity() {
        return inCaptivity;
    }

    public void setInCaptivity(Boolean inCaptivity) {
        this.inCaptivity = inCaptivity;
    }

    public ArrayList<FoodType> getBelly() {
        return belly;
    }

    public void setBelly(ArrayList<FoodType> belly) {
        this.belly = belly;
    }
}
