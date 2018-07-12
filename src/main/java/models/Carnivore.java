package models;

public class Carnivore extends Dinosaur implements IEat {

    public Carnivore(Species species, Boolean inCaptivity) {
        super(species, inCaptivity);

    }

    public Carnivore() {
    }

    public void eat(FoodType food){
        if (food.getType().equals("meat")) {

            this.getBelly().add(food);
        }
    }




}
