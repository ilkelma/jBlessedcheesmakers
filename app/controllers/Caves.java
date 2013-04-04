package controllers;

import play.*;
import play.libs.*;
import play.libs.Json;
import org.codehaus.jackson.*;
import play.mvc.*;

import views.html.*;

import models.*;

public class Caves extends Controller {
  
    public static Result index() {
        return ok("Caves Index!");
    }

    public static Result getById(Long cave) {
        Cave foundCave = Cave.find.byId(cave);
        if(foundCave != null) {
        	if(!request().accepts("text/html") && request().accepts("application/json")) {
        		JsonNode result = Json.toJson(foundCave);
        		return ok(result);
        	} else {
        		return ok("You asked for this Cave: " + foundCave.name);
        	}
        } else {
            return badRequest("The Cave of Caerbannog! Oh. Not the Cave you wanted? Maybe try again?");
        }
    }

    public static Result create() {
    	return new Results.Todo();
    }
  	
    public static Result update(Long cave) {
    	return new Results.Todo();
    }

    public static Result delete(Long cave) {
    	return new Results.Todo();
    }

    public static Result allCheesesInCave(Long cave) {
    	return new Results.Todo();
    }

    public static Result addCheeseToCave(Long cave, Long cheese) {
    	return new Results.Todo();
    }
}