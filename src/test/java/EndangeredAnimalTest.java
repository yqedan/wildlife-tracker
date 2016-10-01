import org.junit.*;
import static org.junit.Assert.*;

public class EndangeredAnimalTest {

  EndangeredAnimal testEndAnimal;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setup(){
    testEndAnimal = new EndangeredAnimal("Bald Eagle",1,1);
  }

  @Test
  public void endangeredAnimal_instatiatesCorrectly_true(){
    assertTrue(testEndAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void equals_returnsTrueIfNameHealthAndAgeAreTheSame_true(){
    EndangeredAnimal testEndAnimal2 = new EndangeredAnimal("Bald Eagle",1,1);
    assertTrue(testEndAnimal.equals(testEndAnimal2));
  }

  @Test
  //tests save()
  public void all_returnsAllInstancesOfEndangeredAnimal_true(){
    EndangeredAnimal testEndAnimal2 = new EndangeredAnimal("Blue Whale",1,1);
    assertTrue(EndangeredAnimal.all().get(0).equals(testEndAnimal));
    assertTrue(EndangeredAnimal.all().get(1).equals(testEndAnimal2));
  }

  @Test
  public void find_returnsNonEndangeredAnimalWithSameId_true() {
    EndangeredAnimal testEndAnimal2 = new EndangeredAnimal("Bald Eagle",1,1);
    assertTrue(testEndAnimal2.equals(EndangeredAnimal.find(testEndAnimal2.getId())));
  }

  @Test(expected = IllegalArgumentException.class)
  public void endangeredAnimal_throwsExceptionIfNoNameIsGiven(){
    EndangeredAnimal testEndAnimal2 = new EndangeredAnimal("",1,1);
  }

}
