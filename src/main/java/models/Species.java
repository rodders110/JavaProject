package models;

public enum Species {

    TREX("Tyrannosaurus Rex", 9),
    STEGOSAURUS("Stegosaurus", 3),
    RAPTOR("Velociraptor", 7),
    TRICERATOPS("Triceratops", 5),
    MINMI("Minmi", 2),
    ALLOSAURUS("Allosaurus", 8);

    private String name;
    private int aggression;

    Species(String name, int aggression) {
        this.name = name;
        this.aggression = aggression;
    }
}
