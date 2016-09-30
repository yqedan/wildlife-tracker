import java.util.List;
import org.sql2o.*;

public class NonEndangeredAnimal extends Animal{

  public static final String TYPE = "non-endangered";

  static{
    type = TYPE;
  }

  public NonEndangeredAnimal(String name){
    this.name = name;
    save();
  }

  public static List<NonEndangeredAnimal> all(){
    return null;
  }

  public static NonEndangeredAnimal find(int id){
    return null;
  }
}
