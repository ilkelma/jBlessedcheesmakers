package models;

import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
public class User extends Model {

	@Id
	@Constraints.Required
	@Formats.NonEmpty
	public String email;
	public String name;
	public String password;

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public static Finder<String,User> find = new Finder<String,User>(
		String.class, User.class
	);

	public static User authenticate(String email, String password) {
		return find.where().eq("email", email).eq("password", password).findUnique();
	}
}