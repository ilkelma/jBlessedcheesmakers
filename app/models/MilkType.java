package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
public class MilkType extends Model {
	
	@Id
	@Constraints.Min(10)
	public Long id;
	public String milkType;
	public String image;

	public static Finder<Long, MilkType> find =
			new Finder<Long, MilkType>(Long.class, MilkType.class);

	public MilkType(String milkType) {
		this.milkType = milkType;
	}
}