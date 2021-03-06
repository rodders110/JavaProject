package db;

import models.*;

public class Seeds {

    public static void seedData() {
        DBHelper.deleteAll(Visitor.class);
        DBHelper.deleteAll(Dinosaur.class);
        DBHelper.deleteAll(Paddock.class);
        DBHelper.deleteAll(Park.class);

        Park park = new Park("Jurassic Park");
        DBHelper.save(park);

        Park park2 = new Park("Triassic Park");
        DBHelper.save(park2);

        Paddock paddock1 = new Paddock(1);
        paddock1.setPark(park);
        DBHelper.save(paddock1);

        Paddock paddock2 = new Paddock(2);
        paddock2.setPark(park);
        DBHelper.save(paddock2);

        Paddock paddock3 = new Paddock(3);
        paddock3.setPark(park);
        DBHelper.save(paddock3);

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
        park.addVisitor(visitor1);
//        visitor1.setPark(park);
        DBHelper.save(visitor1);
        DBHelper.update(park);

        Visitor visitor2 = new Visitor("Curly Girl");
        park.addVisitor(visitor2);
//        visitor2.setPark(park);
        DBHelper.save(visitor2);
        DBHelper.update(park);

        }
}


