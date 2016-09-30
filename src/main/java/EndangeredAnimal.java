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

  static{
    type = TYPE;
  }

  public EndangeredAnimal(String name, int age, int health){
    this.name = name;
    if(age == 0){
      this.age = NEWBORN;
    }else if (age == 1){
      this.age = YOUNG;
    }else{
      this.age = ADULT;
    }
    if(health == 0){
      this.health = ILL;
    }else if (health == 1){
      this.health = OKAY;
    }else{
      this.health = HEALTHY;
    }
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
                .addParameter("type",type)
                .throwOnMappingFailure(false)
                .executeAndFetch(EndangeredAnimal.class);
    }
  }

  public static EndangeredAnimal find(int id){
    return null;
  }
}
