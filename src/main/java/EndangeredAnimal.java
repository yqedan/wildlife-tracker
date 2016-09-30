import java.util.List;
import org.sql2o.*;

public class EndangeredAnimal extends Animal{
  private String health;

  public static final String ILL = "ill";
  public static final String OKAY = "okay";
  public static final String HEALTHY = "healthy";

  private String age;

  public static final String NEWBORN = "newborn";
  public static final String YOUNG = "young";
  public static final String ADULT = "adult";

  public static final String TYPE = "endangered";

  public EndangeredAnimal(String name, int health, int age){
    if(name.equals("")){
      throw new IllegalArgumentException("Please enter the species you found!");
    }
    this.name = name;
    if(health == 0){
      this.health = ILL;
    }else if (health == 1){
      this.health = OKAY;
    }else{
      this.health = HEALTHY;
    }
    if(age == 0){
      this.age = NEWBORN;
    }else if (age == 1){
      this.age = YOUNG;
    }else{
      this.age = ADULT;
    }
    type = TYPE;
    save();
  }

  public String getAge(){
    return age;
  }
  public String getHealth(){
    return health;
  }

  @Override
  public boolean equals(Object otherEndAnimal){
    if (!(otherEndAnimal instanceof EndangeredAnimal)) {
     return false;
   } else {
     EndangeredAnimal newEndAnimal = (EndangeredAnimal) otherEndAnimal;
     return age.equals(newEndAnimal.age) &&
            health.equals(newEndAnimal.health) &&
            super.equals(newEndAnimal);
    }
  }

  @Override
  public void save(){
    super.save();
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET age = :age, health = :health WHERE id = :id";
      con.createQuery(sql)
        .addParameter("age", age)
        .addParameter("health", health)
        .addParameter("id",id)
        .executeUpdate();
    }
  }

  public static List<EndangeredAnimal> all(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE type = :type";
      return con.createQuery(sql)
                .addParameter("type", TYPE)
                .throwOnMappingFailure(false)
                .executeAndFetch(EndangeredAnimal.class);
    }
  }

  public static EndangeredAnimal find(int id){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id = :id";
      return con.createQuery(sql)
                .addParameter("id", id)
                .throwOnMappingFailure(false)
                .executeAndFetchFirst(EndangeredAnimal.class);
    }
  }
}
