import org.sql2o.*;

public abstract class Animal implements CRUDable{

  public int id;
  public String name;
  public String type;

  public int getId(){
    return id;
  }

  public String getName(){
    return name;
  }

  public String getType(){
    return type;
  }

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
      id = (int) con.createQuery(sql, true)
                    .addParameter("name", name)
                    .addParameter("type", type)
                    .executeUpdate()
                    .getKey();
    }
  }

  @Override
  public boolean equals(Object otherAnimal){
    if (!(otherAnimal instanceof Animal)) {
     return false;
   } else {
     Animal newAnimal = (Animal) otherAnimal;
     return name.equals(newAnimal.name);
    }
  }

  public static String getType(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT type FROM animals WHERE id = :id";
    return con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false).executeAndFetchFirst(String.class);
    }
  }

  @Override
  public void update(){

  }

  @Override
  public void delete(){

  }
}
