import org.sql2o.*;

public abstract class Animal implements CRUDable{

  public int id;
  public String name;
  public static String type;

  public int getId(){
    return id;
  }

  public String getName(){
    return name;
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

  @Override
  public void update(){

  }

  @Override
  public void delete(){

  }
}
