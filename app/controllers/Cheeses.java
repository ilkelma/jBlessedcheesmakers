package controllers;

import play.*;
import play.libs.*;
import play.libs.Json;
import org.codehaus.jackson.*;
import play.mvc.*;

import views.html.*;
import models.*;

public class Cheeses extends Controller {
  
    public static Result index() {
        return ok("Cheese Index!");
    }

    public static Result getById(Long cheese) {
        Cheese foundCheese = Cheese.find.byId(cheese);
        if(foundCheese != null) {
        	if(!request().accepts("text/html") && request().accepts("application/json")) {
        		JsonNode result = Json.toJson(foundCheese);
                return ok(result);
        	} else {
        		return ok("You asked for this Cheese: " + foundCheese.getName());
        	}
        } else {
            return badRequest("Sorry sir, we're out of that cheese (Monty Python)");
        }
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