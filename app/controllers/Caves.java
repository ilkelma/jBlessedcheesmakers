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
    	if(request().accepts("application/json")) {
    		JsonNode result = Json.parse("{ id: " + cave + "}");
    		return ok(result);
    	} else {
    		return ok("You asked for this Cave: " + cave);
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