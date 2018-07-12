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
        paddock.addDinosaur(dinosaur);
        paddock.addDinosaur(dino1);
    }

    @Test
    public void hasDino() {
        assertEquals(2, paddock.getDinosaurs().size());
    }

    @Test
    public void canRampage() {
        paddock.rampage();
        assertEquals(86, paddock.getIntegrity());
    }

    @Test
    public void hasnumber() {

        assertEquals(1, paddock.getNumber());
    }
}
