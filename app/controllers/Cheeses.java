package controllers;

import play.*;
import play.libs.*;
import play.libs.Json;
import org.codehaus.jackson.*;
import play.mvc.*;
import java.util.*;
import java.io.File;
import play.data.validation.Constraints.*;
import play.data.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;

import static play.data.Form.*;

import views.html.*;
import models.*;

public class Cheeses extends Controller {

    public static final String PAGE_ADD_CHEESE = "Add Cheese";
    public static final String PAGE_CHEESES = "Cheeses";

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
            return ok(views.html.cheeses.cheeseIndex.render(PAGE_CHEESES, cheeses, user));
        } else {
            List<Cheese> cheeses = 
                    Cheese.find.where().eq("visible", true).findList();
            return ok(views.html.cheeses.cheeseIndex.render(PAGE_CHEESES, cheeses, null));
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
        return ok(views.html.cheeses.newCheese.render(PAGE_ADD_CHEESE, form(AddCheese.class),
                    CheeseStyle.find.all(), MilkType.find.all(),
                    Cave.find.where().eq("owner.email", session("email")).findList()));
    }

    public static Result create() {
        Form<AddCheese> cheeseForm = form(AddCheese.class);
        Form<AddCheese> filledForm = cheeseForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(views.html.cheeses.newCheese.render(PAGE_ADD_CHEESE, filledForm,
                    CheeseStyle.find.all(), MilkType.find.all(),
                    Cave.find.where().eq("owner.email", session("email")).findList()));
        } else {
            MultipartFormData body = request().body().asMultipartFormData();
            FilePart image = body.getFile("image");
            Cheese newCheese = new Cheese(filledForm.get().name);
            // Set required fields
            newCheese.setUser(User.find.byId(session("email")));
            newCheese.setFinished(filledForm.get().finished);
            newCheese.setVisible(filledForm.get().visible);
            newCheese.setCheeseStyle(filledForm.get().cheeseStyle);
            newCheese.setMilkType(filledForm.get().milkType);
            // Set nullable fields
            if(filledForm.get().startDate != null) {
                newCheese.setStartDate(filledForm.get().startDate);
            }
            if(filledForm.get().finishDate != null) {
                newCheese.setFinishDate(filledForm.get().finishDate);
            }
            if(filledForm.get().cave != null) {
                newCheese.setCave(Cave.find.byId(filledForm.get().cave));
            }
            if(filledForm.get().recipeSource != null) {
                newCheese.setRecipeSource(filledForm.get().recipeSource);
            }
            if(filledForm.get().coagulant != null) {
                newCheese.setCoagulant(filledForm.get().coagulant);
            }
            if(filledForm.get().inoculant != null) {
                newCheese.setInoculant(filledForm.get().inoculant);
            }
            // Set image path and save image if uploaded
            if(image != null) {
                newCheese.setImage(image.getFilename());
                File file = image.getFile();
                // Save file here
            } else {
                newCheese.setImage("default.png");
            }
            // Persist the cheese!
            newCheese.save();

            return redirect(routes.Cheeses.index());
        }        
    }
  	
    public static Result update(Long cheese) {
    	return new Results.Todo();
    }

    public static Result delete(Long cheese) {
    	return new Results.Todo();
    }
}