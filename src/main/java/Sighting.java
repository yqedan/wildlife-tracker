import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Sighting implements CRUDable{
  private int id;
  private int animalId;
  private String location;
  private String rangerName;
  private Timestamp time;
  //data from animalId stored in table
  private String type;
  private String species;
  private String age;
  private String health;

  public Sighting(int animalId, String location, String rangerName){
    if(location.equals("")){
      throw new IllegalArgumentException("Please enter where you found this animal!");
    }
    if(rangerName.equals("")){
      throw new IllegalArgumentException("Please enter your name!");
    }
    this.animalId = animalId;
    this.location = location;
    this.type = Animal.getType(animalId);
    if(type.equals("endangered")){
      EndangeredAnimal endAnimal = EndangeredAnimal.find(animalId);
      this.species = endAnimal.getName();
      this.age = endAnimal.getAge();
      this.health = endAnimal.getHealth();
    }else{
      NonEndangeredAnimal animal = NonEndangeredAnimal.find(animalId);
      this.species = animal.getName();
      this.age = "-";
      this.health = "-";
    }
    this.rangerName = rangerName;
    save();
  }

  public int getId(){
    return id;
  }

  public int getAnimalId(){
    return animalId;
  }

  public String getSpecies(){
    return species;
  }

  public String getType(){
    return type;
  }

  public String getAge(){
    return age;
  }

  public String getHealth(){
    return health;
  }

  public String getLocation(){
    return location;
  }

  public String getRangerName(){
    return rangerName;
  }

  public Timestamp getTime(){
    return time;
  }

  public String getFormattedDateTime(){
    SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd yyyy hh:mm a");
    return formatter.format(time);
  }

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (animalId, location, rangerName, time, species, type, age, health) VALUES (:animalId, :location, :rangerName, now(), :species, :type, :age, :health)";
      id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", animalId)
                    .addParameter("location", location)
                    .addParameter("rangerName", rangerName)
                    .addParameter("species", species)
                    .addParameter("type", type)
                    .addParameter("age", age)
                    .addParameter("health", health)
                    .executeUpdate()
                    .getKey();
    }
  }

  @Override
  public boolean equals(Object otherSighting){
    if (!(otherSighting instanceof Sighting)) {
     return false;
   } else {
     Sighting newSighting = (Sighting) otherSighting;
     return animalId == newSighting.animalId &&
     location.equals(newSighting.location) &&
     rangerName.equals(newSighting.rangerName);
    }
  }

  public static List<Sighting> all(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings";
      return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE id = :id";
      return con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Sighting.class);
    }
  }

  @Override
  public void update(){

  }

  @Override
  public void delete(){

  }
}
