package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IMeal;
import de.hska.iwi.mgwt.demo.backend.autobean.IMealGroup;

/**
 * Model which holds information about a MealGroup. Title a message as well as one or more Meals.
 * @author Nico
 *
 */
public class MealGroup {
	
	private String title;
	private String message;
	
	private List<Meal> meals;
	
	/**
	 * C'tor which creates a deep copy of the given Interface type.
	 * @param mealGroup the given interface implementation type.
	 */
	public MealGroup(IMealGroup mealGroup) {
		this.title = mealGroup.getTitle();
		this.message = mealGroup.getMessage();
		meals = new ArrayList<Meal>();
		for (IMeal meal : mealGroup.getMeals()) {
			meals.add(new Meal(meal));
		}
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @return the meals
	 */
	public List<Meal> getMeals() {
		return meals;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @param meals the meals to set
	 */
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
