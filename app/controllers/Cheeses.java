package controllers;

import play.*;
import play.libs.*;
import play.libs.Json;
import org.codehaus.jackson.*;
import play.mvc.*;
import java.util.*;
import play.data.validation.Constraints.*;

import static play.data.Form.*;

import views.html.*;
import models.*;

public class Cheeses extends Controller {

    public static class AddCheese {

        @Required
        public String name;
        @Required
        public boolean finished;
        public Date startDate;
        public Date finishDate;
        @Required
        public boolean visible;
        public Long cave;
        @Required
        public String cheeseStyle;
        public String recipeSource;
        public String coagulant;
        public String inoculant;
        @Required
        public String milkType;
        public String image;

        // public Map<String, List<ValidationError>> validate() {
        //     Map<String, List<ValidationError>> map = new HashMap<String, List<ValidationError>>();
        //     if()
        //     return map;
        // }
    }
  
    public static Result index() {
        // If the user is logged in, then display their cheeses
        // TODO: make it so that the two lists of cheeeses can be viewed while logged in
        if(session("email") != null) {
            List<Cheese> cheeses = 
                    Cheese.find.where().eq("user.email", session("email")).findList();
            User user = User.find.byId(session("email"));
            return ok(views.html.cheeses.cheeseIndex.render("Cheeses", cheeses, user));
        } else {
            List<Cheese> cheeses = 
                    Cheese.find.where().eq("visible", true).findList();
            return ok(views.html.cheeses.cheeseIndex.render("Cheeses", cheeses, null));
        }
    }

    public static Result getById(Long cheese) {
        Cheese foundCheese = Cheese.find.byId(cheese);
        if(foundCheese != null) {
        	if(!request().accepts("text/html") && request().accepts("application/json")) {
        		JsonNode result = Json.toJson(foundCheese);
                return ok(result);
        	} else {
        		return ok("You asked for this Cheese: " + foundCheese.name);
        	}
        } else {
            return badRequest("Sorry sir, we're out of that cheese (Monty Python)");
        }
    }

    public static Result addCheese() {
        return ok(views.html.cheeses.newCheese.render("Add Cheese", form(AddCheese.class),
                    CheeseStyle.find.all(), MilkType.find.all(),
                    Cave.find.where().eq("owner.email", session("email")).findList()));
    }

    public static Result create() {
    	return new Results.Todo();
    }
  	
    public static Result update(Long cheese) {
    	return new Results.Todo();
    }

    public static Result delete(Long cheese) {
    	return new Results.Todo();
    }
}