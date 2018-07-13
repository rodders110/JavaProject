package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="carnivores")
public class Carnivore extends Dinosaur implements IEat {

    public Carnivore(Species species, Boolean inCaptivity) {
        super(species, inCaptivity);

    }

    public Carnivore() {
    }

    public void eat(FoodType food){
        if (food.getType().equals("meat")) {
             this.setBelly(this.getBelly() + 1);
        }
    }




}
