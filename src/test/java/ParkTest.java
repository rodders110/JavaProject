//import models.*;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class ParkTest {
//
//    Park park;
//    Paddock paddock;
//    Carnivore dinosaur1;
//    Herbivore dinosaur2;
//    Visitor visitor1;
//    Visitor visitor2;
//
//    @Before
//    public void before(){
//        park = new Park("Jurasic Park");
//        paddock = new Paddock(1);
//        dinosaur1 = new Carnivore(Species.RAPTOR, true);
//        dinosaur2 = new Herbivore(Species.MINMI, true);
//        visitor1 = new Visitor("Colin");
//        visitor2 = new Visitor("Tara");
//        park.addPaddock(paddock);
//        park.getPaddocks().get(0).addDinosaur(dinosaur1);
//    }
//
//    @Test
//    public void canAddDino() {
//        assertEquals(1, park.getPaddocks().size());
//    }
//
//    @Test
//    public void cannotAddHerbivoreToCarnivorePaddock() {
//        park.getPaddocks().get(0).addDinosaur(dinosaur2);
//        assertEquals(1, park.getPaddocks().size());
//    }
//
//    @Test
//    public void canAddVisitor() {
//        park.addVisitor(visitor1);
//        park.addVisitor(visitor2);
//        assertEquals(2, park.getTotalVisitors());
//    }
//
//    @Test
//    public void canRemoveVisitors() {
//        park.addVisitor(visitor1);
//        park.addVisitor(visitor2);
//        park.exitVisitor(visitor1);
//        assertEquals(2, park.getTotalVisitors());
//        assertEquals(1, park.getVisitors().size());
//    }
//
//    @Test
//    public void canEvacuateThePark() {
//        park.addVisitor(visitor1);
//        park.addVisitor(visitor2);
//        park.evacuate();
//        assertEquals(0, park.getVisitors().size());
//    }
//
//    @Test
//    public void canCheckForRampage() {
//
//        park.getPaddocks().get(0).setIntegrity(0);
//        assertEquals(true, park.checkRampage());
//
//    }
//}
