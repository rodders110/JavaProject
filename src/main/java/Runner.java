import db.DBHelper;
import models.*;

public class Runner {

    public static void main(String[] args) {

    Park park = new Park("Jurassic Park");
    DBHelper.save(park);

    Paddock paddock1 = new Paddock(1);
    park.addPaddock(paddock1);
    DBHelper.save(paddock1);

    Paddock paddock2 = new Paddock(2);
    DBHelper.save(paddock2);




    }

}
