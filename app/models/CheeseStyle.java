package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
public class CheeseStyle extends Model {
	
	@Id
	@Constraints.Min(10)
	public Long id;
	public String cheeseStyle;

		public static Finder<Long, CheeseStyle> find =
			new Finder<Long, CheeseStyle>(Long.class, CheeseStyle.class);

	public CheeseStyle(String cheeseStyle) {
		this.cheeseStyle = cheeseStyle;
	}
}