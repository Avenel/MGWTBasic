package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface IMealGroup {
	/**
	 * @return the title of the MealGroup
	 */
	public String getTitle();
	/**
	 * @param title to set
	 */
	public void setTitle(String title);
	/**
	 * @return list of {@link IMeal}
	 */
	public List<IMeal> getMeals();
	/**
	 * @param meals value to set
	 */
	public void setMeals(List<IMeal> meals);
	/**
	 * @return message of this MealGroup
	 */
	public String getMessage();
	/**
	 * @param message value to set
	 */
	public void setMessage(String message);
}