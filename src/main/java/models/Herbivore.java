package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="herbivores")
public class Herbivore extends Dinosaur implements IEat {

    public Herbivore(Species species, Boolean inCaptivity) {
        super(species, inCaptivity);
    }

    public Herbivore() {
    }

    public void eat(FoodType food) {
        if (food.getType().equals("herb")) {

            this.setBelly(this.getBelly() + 1);
        }

    }
}
