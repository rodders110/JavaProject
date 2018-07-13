import db.DBHelper;
import db.DBPaddock;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

    Park park = new Park("Jurassic Park");
    DBHelper.save(park);

    Paddock paddock1 = new Paddock(1);
    paddock1.setPark(park);
    DBHelper.save(paddock1);

    Paddock paddock2 = new Paddock(2);
    paddock2.setPark(park);
    DBHelper.save(paddock2);

    Carnivore raptor = new Carnivore(Species.RAPTOR, true);
    raptor.setPaddock(paddock1);
    DBHelper.save(raptor);

    Herbivore minmi = new Herbivore(Species.MINMI, true);
    minmi.setPaddock(paddock2);
    DBHelper.save(minmi);

    Herbivore steg = new Herbivore(Species.STEGOSAURUS, true);
    steg.setPaddock(paddock2);
    DBHelper.save(steg);

    Visitor visitor1 = new Visitor("Curly Boy");
    visitor1.setPark(park);
    DBHelper.save(visitor1);

    Visitor visitor2 = new Visitor("Curly Girl");
    visitor2.setPark(park);
    DBHelper.save(visitor2);

    List<Dinosaur> dinosaursInPaddock = DBPaddock.getDinosInPaddock(paddock2);

    }

}
