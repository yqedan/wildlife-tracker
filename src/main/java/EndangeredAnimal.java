import java.util.List;

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

  public static List<EndangeredAnimal> all(){
    return null;
  }

  public static EndangeredAnimal find(int id){
    return null;
  }
}
