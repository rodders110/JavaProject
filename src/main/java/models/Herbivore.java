package models;

public class Herbivore extends Dinosaur implements IEat {

    public Herbivore(Species species, Boolean inCaptivity) {
        super(species, inCaptivity);
    }

    public Herbivore() {
    }

    public void eat(FoodType food) {
        if (food.getType().equals("herb")) {

            this.getBelly().add(food);
        }

    }
}
