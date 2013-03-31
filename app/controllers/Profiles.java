package controllers;

import play.*;
import play.libs.*;
import play.libs.Json;
import org.codehaus.jackson.*;
import play.mvc.*;

import views.html.*;

public class Profiles extends Controller {

    public static Result index() {
        return ok("Profiles Index!");
    }

    public static Result getById(Long id) {
    	if(request().accepts("application/json")) {
    		JsonNode result = Json.parse("{ id: " + id + "}");
    		return ok(result);
    	} else {
    		return ok("You asked for this User: " + id);
    	}
    }

    public static Result create() {
    	return new Results.Todo();
    }
  	
    public static Result update(Long id) {
    	return new Results.Todo();
    }

    public static Result delete(Long id) {
    	return new Results.Todo();
    }
  
}