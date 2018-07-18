import db.DBDino;
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

    List<Visitor> getAllVisitors = DBHelper.getAll(Visitor.class);
    List<Dinosaur> getallDinosaurs = DBHelper.getAll(Dinosaur.class);
    List<Paddock> getAllPaddocks = DBHelper.getAll(Paddock.class);
    List<Herbivore> getAllHerbivores = DBHelper.getAll(Herbivore.class);
    List<Carnivore> getallCarnivores = DBHelper.getAll(Carnivore.class);

    List<Dinosaur> dinos = DBPaddock.getDinosInPaddock(paddock2);
    String qury = dinos.get(0).getClass().toString();




    }

}
