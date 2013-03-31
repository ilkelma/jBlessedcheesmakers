package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static class Login {
        
        public String email;
        public String password;
        
        public String validate() {
            if(User.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
        
    }

    /**
     * Login page.
     */
    public static Result login() {
        // return ok(
        //     login.render(form(Login.class))
        // );
        return new Results.Todo();
    }
    
    /**
     * Handle login form submission.
     */
    public static Result authenticate() {
        // Form<Login> loginForm = form(Login.class).bindFromRequest();
        // if(loginForm.hasErrors()) {
        //     return badRequest(login.render(loginForm));
        // } else {
        //     session("email", loginForm.get().email);
        //     return redirect(
        //         routes.Application.index()
        //     );
        // }
        return new Results.Todo();
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
    }
  
  
}
