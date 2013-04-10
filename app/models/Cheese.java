package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
public class Cheese extends Model {
	
	@Id
	@Constraints.Min(10)
	public Long id;

	@Constraints.Required
	public String name;
	public boolean finished;
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date startDate;
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date finishDate;

	@Constraints.Required
	public boolean visible;

	@OneToOne
	public Cave cave;
	@OneToOne
	@Constraints.Required
	public User user;

	public String cheeseStyle;
	public String recipeSource;
	public String coagulant;
	public String inoculant;
	public String milkType;

	public static Finder<Long,Cheese> find = 
			new Finder<Long,Cheese>(Long.class, Cheese.class);

	public Cheese(String name) {
		this.name = name;
	}

	public String calculateAgingTime() {
		return "NYI";
	}

}