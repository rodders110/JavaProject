package models;

public enum Species {

    TREX("Tyrannosaurus Rex", 9, "https://en.wikipedia.org/wiki/Tyrannosaurus"),
    STEGOSAURUS("Stegosaurus", 3, "https://en.wikipedia.org/wiki/Stegosaurus"),
    RAPTOR("Velociraptor", 7, "https://en.wikipedia.org/wiki/Velociraptor"),
    TRICERATOPS("Triceratops", 5, "https://en.wikipedia.org/wiki/Triceratops"),
    MINMI("Minmi", 2, "https://en.wikipedia.org/wiki/Minmi_paravertebra"),
    ALLOSAURUS("Allosaurus", 8, "https://en.wikipedia.org/wiki/Allosaurus");

    private String name;
    private int aggression;
    private String info;

    Species(String name, int aggression, String info) {
        this.name = name;
        this.aggression = aggression;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAggression() {
        return aggression;
    }

    public void setAggression(int aggression) {
        this.aggression = aggression;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
