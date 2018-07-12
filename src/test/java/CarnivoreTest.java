import models.Carnivore;
import models.FoodType;
import models.Species;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarnivoreTest {

    Carnivore raptor;
    Enum<Species> species;

    @Before
    public void setUp() throws Exception {

        raptor = new Carnivore(Species.RAPTOR, true);

    }

    @Test
    public void canEatMeat() {
        raptor.eat(FoodType.SHEEP);
        assertEquals(1, raptor.getBelly().size());
    }
}
