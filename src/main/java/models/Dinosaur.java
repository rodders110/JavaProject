package models;

public abstract class Dinosaur {

    private int id;
    private Species species;
    private Boolean inCaptivity;

    public Dinosaur(Species species, Boolean inCaptivity) {
        this.species = species;
        this.inCaptivity = inCaptivity;
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
}
