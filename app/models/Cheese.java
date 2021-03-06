package models;

import java.util.*;
import javax.persistence.*;
import java.text.SimpleDateFormat;

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
	public String image;

	public static Finder<Long,Cheese> find = 
			new Finder<Long,Cheese>(Long.class, Cheese.class);

	public Cheese(String name) {
		this.name = name;
	}

	public String calculateAgingTime() {
		return "NYI";
	}

	public boolean caveExists() {
		return this.cave != null ? true : false;
	}

	public Cave pullInCave() {
		return this.cave;
	}

	public String formatDate(String dateToFormat) {
		Date theDate;
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		if(dateToFormat == "startDate") {
			theDate = this.startDate;
		} else if(dateToFormat == "finishDate") {
			theDate = this.finishDate;
		} else {
			return "invalid option";
		}
		return theDate.toString();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public boolean getFinished(){
		return finished;
	}

	public void setFinished(boolean finished){
		this.finished = finished;
	}

	public Date getStartDate(){
		return startDate;
	}

	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	public Date getFinishDate(){
		return finishDate;
	}

	public void setFinishDate(Date finishDate){
		this.finishDate = finishDate;
	}
	public boolean getVisible(){
		return visible;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}
	public Cave getCave(){
		return cave;
	}

	public void setCave(Cave cave){
		this.cave = cave;
	}
	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}
	public String getCheeseStyle(){
		return cheeseStyle;
	}

	public void setCheeseStyle(String cheeseStyle){
		this.cheeseStyle = cheeseStyle;
	}
	public String getRecipeSource(){
		return recipeSource;
	}

	public void setRecipeSource(String recipeSource){
		this.recipeSource = recipeSource;
	}
	public String getCoagulant(){
		return coagulant;
	}

	public void setCoagulant(String coagulant){
		this.coagulant = coagulant;
	}
	public String getInoculant(){
		return inoculant;
	}

	public void setInoculant(String inoculant){
		this.inoculant = inoculant;
	}
	public String getMilkType(){
		return milkType;
	}

	public void setMilkType(String milkType){
		this.milkType = milkType;
	}
	public String getImage(){
		return image;
	}

	public void setImage(String image){
		this.image = image;
	}
}