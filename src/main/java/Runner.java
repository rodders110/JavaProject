import db.DBHelper;
import models.*;

public class Runner {

    public static void main(String[] args) {

    Park park = new Park("Jurassic Park");
    DBHelper.save(park);

    Paddock paddock1 = new Paddock(1);
    DBHelper.save(paddock1);

    Paddock paddock2 = new Paddock(2);
    DBHelper.save(paddock2);

    Carnivore raptor = new Carnivore(Species.RAPTOR, true);
    DBHelper.save(raptor);

    Herbivore minmi = new Herbivore(Species.MINMI, true);
    DBHelper.save(minmi);

    Herbivore steg = new Herbivore(Species.STEGOSAURUS, true);
    DBHelper.save(steg);

    Visitor visitor1 = new Visitor("Curly Boy");
    DBHelper.save(visitor1);

    Visitor visitor2 = new Visitor("Curly Girl");
    DBHelper.save(visitor2);


    }

}
