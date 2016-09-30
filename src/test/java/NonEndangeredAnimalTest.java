import org.junit.*;
import static org.junit.Assert.*;

public class NonEndangeredAnimalTest {

  NonEndangeredAnimal testAnimal;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setup(){
    testAnimal = new NonEndangeredAnimal("monkey");
  }

  @Test
  public void nonEndangeredAnimal_instatiatesCorrectly_true(){
    assertTrue(testAnimal instanceof NonEndangeredAnimal);
  }


}
