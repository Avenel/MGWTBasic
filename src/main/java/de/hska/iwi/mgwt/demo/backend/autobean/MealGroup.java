package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface MealGroup {

	public String getTitle();

	public void setTitle(String title);

	public List<Meal> getMeals();

	public void setMeals(List<Meal> meals);

	public String getMessage();

	public void setMessage(String message);

//	public Map<String, Object> getAdditionalProperties();

//	public void setAdditionalProperties(String name, Object value);

}