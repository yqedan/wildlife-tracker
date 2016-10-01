import org.junit.*;
import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void getType_getsAnimalType_true(){
    NonEndangeredAnimal testAnimal = new NonEndangeredAnimal("monkey");
    Sighting testSighting = new Sighting(testAnimal.getId(), "Somehwere over the rainbow", "Yusuf");
    assertTrue(Animal.getType(testSighting.getAnimalId()).equals("non-endangered"));
  }

}
