import models.FoodType;
import models.Herbivore;
import models.Species;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HerbivoreTest {

    Herbivore minmi;
    Species species;

    @Before
    public void setUp() throws Exception {

        minmi = new Herbivore (species.MINMI, true);
    }

    @Test
    public void canEatPlants() {
        minmi.eat(FoodType.CARROT);
        assertEquals(1, minmi.getBelly());
    }

    @Test
    public void wontEatMeat() {
        minmi.eat(FoodType.SHEEP);
        assertEquals(0, minmi.getBelly());
    }
}
