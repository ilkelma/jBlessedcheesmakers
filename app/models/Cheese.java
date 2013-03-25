package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
class Cheese extends Model {
	
	@Id
	@Constraints.Min(10)
	public Long id;

	@Constraints.Required
	public String name;

	public boolean finished;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date startDate;

	@OneToOne
	public Cave cave;

	public String cheeseStyle;
	public String recipeSource;
	public String coagulant;
	public String bacteria;

	public static Finder<Long,Cheese> find = 
			new Finder<Long,Cheese>(Long.class, Cheese.class);

}