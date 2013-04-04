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

    public static Result getByEmail(String user) {
    	if(request().accepts("application/json")) {
    		JsonNode result = Json.parse("{ id: " + user + "}");
    		return ok(result);
    	} else {
    		return ok("You asked for this User: " + user);
    	}
    }

    public static Result create() {
    	return new Results.Todo();
    }
  	
    public static Result update(String user) {
    	return new Results.Todo();
    }

    public static Result delete(String user) {
    	return new Results.Todo();
    }
  
}