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

  @Test
  public void equals_returnsTrueIfNameIsTheSame_true(){
    NonEndangeredAnimal testAnimal2 = new NonEndangeredAnimal("monkey");
    assertTrue(testAnimal.equals(testAnimal2));
  }

  @Test
  //tests save()
  public void all_returnsAllInstancesOfNonEndangeredAnimal_true(){
    NonEndangeredAnimal testAnimal2 = new NonEndangeredAnimal("Elephant");
    assertTrue(NonEndangeredAnimal.all().get(0).equals(testAnimal));
    assertTrue(NonEndangeredAnimal.all().get(1).equals(testAnimal2));
  }

  @Test
  public void find_returnsNonEndangeredAnimalWithSameId_true() {
    NonEndangeredAnimal testAnimal2 = new NonEndangeredAnimal("Elephant");
    assertTrue(testAnimal2.equals(NonEndangeredAnimal.find(testAnimal2.getId())));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonEndangeredAnimal_throwsExceptionIfNoNameIsGiven(){
    NonEndangeredAnimal testAnimal2 = new NonEndangeredAnimal("");
  }

}
