package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Cheeses extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
  
}