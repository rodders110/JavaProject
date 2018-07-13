import db.DBHelper;
import models.*;

public class Runner {

    public static void main(String[] args) {

        Visitor visitor1 = new Visitor("Colin");


        Visitor visitor2 = new Visitor("Tara");


        Carnivore raptor = new Carnivore(Species.RAPTOR, true);

        Herbivore minmi = new Herbivore(Species.MINMI, true);

        Herbivore steg = new Herbivore(Species.STEGOSAURUS, true);


        Paddock paddock1 = new Paddock(1);


        Paddock paddock2 = new Paddock(2);


        Park park = new Park("Jurassic Park");

        paddock1.addDinosaur(raptor);
        paddock2.addDinosaur(minmi);
        paddock2.addDinosaur(steg);

        park.addPaddock(paddock1);
        park.addPaddock(paddock2);

        park.addVisitor(visitor1);
        park.addVisitor(visitor2);

        DBHelper.save(visitor1);
        DBHelper.save(visitor2);
        DBHelper.save(paddock1);
        DBHelper.save(paddock2);
        DBHelper.save(raptor);
        DBHelper.save(minmi);
        DBHelper.save(steg);
        DBHelper.save(park);


    }

}
