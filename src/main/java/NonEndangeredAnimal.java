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
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE type = :type";
      return con.createQuery(sql)
                .addParameter("type", type)
                .throwOnMappingFailure(false)
                .executeAndFetch(NonEndangeredAnimal.class);
    }
  }

  public static NonEndangeredAnimal find(int id){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id = :id";
      return con.createQuery(sql)
                .addParameter("id", id)
                .throwOnMappingFailure(false)
                .executeAndFetchFirst(NonEndangeredAnimal.class);
    }
  }
}
