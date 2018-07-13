import db.DBHelper;
import models.*;

public class Runner {

    public static void main(String[] args) {

        Carnivore raptor = new Carnivore(Species.RAPTOR, true);
        DBHelper.save(raptor);
        Carnivore allosaurus = new Carnivore(Species.ALLOSAURUS, true);
        DBHelper.save(allosaurus);
        Herbivore minmi = new Herbivore(Species.MINMI, true);
        DBHelper.save(minmi);
        Herbivore steg = new Herbivore(Species.STEGOSAURUS, true);
        DBHelper.save(steg);

        Paddock paddock1 = new Paddock(1);
        DBHelper.save(paddock1);

        Paddock paddock2 = new Paddock(2);
        DBHelper.save(paddock2);

        Visitor visitor1 = new Visitor("Colin");
        DBHelper.save(visitor1);

        Visitor visitor2 = new Visitor("Tara");
        DBHelper.save(visitor2);

    }

}
