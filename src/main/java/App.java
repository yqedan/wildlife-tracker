import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        List<Animal> animals = new ArrayList<>();
        animals.addAll(NonEndangeredAnimal.all());
        animals.addAll(EndangeredAnimal.all());
        model.put("animals", animals);
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     post("/animals/new", (request, response) -> {
       String species = request.queryParams("species");
       String type = request.queryParams("type");
       int health = Integer.parseInt(request.queryParams("health"));
       int age = Integer.parseInt(request.queryParams("age"));
       //TODO: catch exceptions here
       if(type.equals("endangered")){
         EndangeredAnimal endAnimal = new EndangeredAnimal(species,health,age);
       }else{
         NonEndangeredAnimal animal = new NonEndangeredAnimal(species);
       }
       response.redirect("/");
       return null;
    });
  }
}
