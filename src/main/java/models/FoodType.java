package models;

public enum FoodType {



    GOAT("Goat", "meat"),
    SHEEP("Sheep", "meat"),
    CARROT("Carrot", "herb"),
    TURNIP("Turnip", "herb");

    private String name;
    private String type;

    FoodType(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
