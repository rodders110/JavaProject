package models;

public class Visitor {

    private int id;
    private String  name;


    public Visitor() {
    }

    public Visitor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void feed(Dinosaur dinosaur, Enum<FoodType> foodTypeEnum ){

        dinosaur.eat(foodTypeEnum);

    }


}
