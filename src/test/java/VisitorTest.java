import models.Carnivore;
import models.FoodType;
import models.Species;
import models.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Carnivore dinosaur;

    @Before
    public void setUp() throws Exception {
        visitor = new Visitor("Curly Boy");
        dinosaur = new Carnivore(Species.RAPTOR, true);
    }

    @Test
    public void canFeedDinosaur() {
        visitor.feed(dinosaur, FoodType.SHEEP);
        assertEquals(1, dinosaur.getBelly().size());
    }
}
