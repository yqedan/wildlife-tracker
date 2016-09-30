import java.util.List;
import java.sql.Timestamp;
import org.sql2o.*;

public class Sighting implements CRUDable{
  private int id;
  private int animalId;
  private String location;
  private String rangerName;
  private Timestamp time;

  public Sighting(int animalId, String location, String rangerName){
    this.animalId = animalId;
    this.location = location;
    this.rangerName = rangerName;
    save();
  }

  public int getId(){
    return id;
  }

  public int getAnimalId(){
    return animalId;
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

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (animalId, location, rangerName, time) VALUES (:animalId, :location, :rangerName, now())";
      id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", animalId)
                    .addParameter("location", location)
                    .addParameter("rangerName", rangerName)
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
