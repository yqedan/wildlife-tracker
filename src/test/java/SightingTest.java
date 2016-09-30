import org.junit.*;
import static org.junit.Assert.*;

public class SightingTest {

  NonEndangeredAnimal testAnimal;
  Sighting testSighting;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setup(){
    testAnimal = new NonEndangeredAnimal("monkey");
    testSighting = new Sighting(testAnimal.getId(), "Somehwere over the rainbow", "Yusuf");
  }

  @Test
  public void sighting_instatiatesCorrectly_true(){
    assertTrue(testSighting instanceof Sighting);
  }

  @Test
  public void equals_returnsTrueIfAnimalIdRangerNameAndLocationAreTheSame_true(){
    Sighting testSighting2 = new Sighting(testAnimal.getId(), "Somehwere over the rainbow", "Yusuf");
    assertTrue(testSighting.equals(testSighting2));
  }

  @Test
  public void all_returnsAllInstancesOfNonEndangeredAnimal_true(){
    Sighting testSighting2 = new Sighting(testAnimal.getId(), "In the elements", "Joe Test");
    assertTrue(Sighting.all().get(0).equals(testSighting));
    assertTrue(Sighting.all().get(1).equals(testSighting2));
  }

}
