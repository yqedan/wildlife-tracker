import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("animals", NonEndangeredAnimal.all());
      model.put("endAnimals", EndangeredAnimal.all());
      model.put("newAnimalMessage", request.session().attribute("newAnimalMessage"));
      model.put("newSightingMessage", request.session().attribute("newSightingMessage"));
      request.session().attribute("newAnimalMessage", null);
      request.session().attribute("newSightingMessage", null);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/animals/new", (request, response) -> {
      String species = request.queryParams("species");
      String type = request.queryParams("type");
      int health = Integer.parseInt(request.queryParams("health"));
      int age = Integer.parseInt(request.queryParams("age"));
      try{
        if(type.equals("endangered")){
          EndangeredAnimal endAnimal = new EndangeredAnimal(species,health,age);
        }else{
          NonEndangeredAnimal animal = new NonEndangeredAnimal(species);
        }
      }catch(IllegalArgumentException e){
        request.session().attribute("newAnimalMessage", e.getMessage());
      }
      response.redirect("/");
      return null;
    });

    post("/sightings/new", (request, response) -> {
      String rangerName = request.queryParams("rangerName");
      String location = request.queryParams("location");
      int animalId = Integer.parseInt(request.queryParams("animalId"));
      try{
        Sighting sighting = new Sighting(animalId,location,rangerName);
      }catch(IllegalArgumentException e){
        request.session().attribute("newSightingMessage", e.getMessage());
      }
      response.redirect("/");
      return null;
    });

    get("/sightings/all", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("sightings", Sightings.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
