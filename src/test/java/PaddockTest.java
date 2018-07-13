import models.Carnivore;
import models.Paddock;
import models.Species;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {

    Paddock paddock;
    Carnivore dinosaur;
    Carnivore dino1;

    @Before
    public void before(){

        dinosaur = new Carnivore(Species.RAPTOR, true);
        dino1 = new Carnivore(Species.RAPTOR, true);
        paddock = new Paddock(1);
        dinosaur.setPaddock(paddock);
        dino1.setPaddock(paddock);
    }

//    @Test
//    public void canRampage() {
//        paddock.rampage();
//        assertEquals(86, paddock.getIntegrity());
//    }

    @Test
    public void hasNumber() {

        assertEquals(1, paddock.getNumber());
    }
}
