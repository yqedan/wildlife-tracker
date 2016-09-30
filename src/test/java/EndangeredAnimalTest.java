import org.junit.*;
import static org.junit.Assert.*;

public class EndangeredAnimalTest {
  EndangeredAnimal testEndAnimal;
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setup(){
    testEndAnimal = new EndangeredAnimal("bald eagle",1,1);
  }

  @Test
  public void endangeredAnimal_instatiatesCorrectly_true(){
    assertTrue(testEndAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void equals_returnsTrueIfNameHealthAndAgeAreTheSame_true(){
    EndangeredAnimal testEndAnimal2 = new EndangeredAnimal("bald eagle",1,1);
    assertTrue(testEndAnimal.equals(testEndAnimal2));
  }
}
