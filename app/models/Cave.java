package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Cave extends Model {

	@Id
	@Constraints.Min(10)
	public Long id;

	@Constraints.Required
	public String name;

	@ManyToOne
	public User owner;

	public Cave(String name, User owner) {
		this.name = name;
		this.owner = owner;
	}

	public static Finder<Long,Cave> find = 
			new Finder<Long,Cave>(Long.class, Cave.class);

	public List<Cheese> listCheeses() {
		return Cheese.find.where().eq("cheese.cave.id", id).findList(); 
	}
}