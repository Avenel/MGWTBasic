package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface IMealGroup {

	public String getTitle();

	public void setTitle(String title);

	public List<IMeal> getMeals();

	public void setMeals(List<IMeal> meals);

	public String getMessage();

	public void setMessage(String message);

//	public Map<String, Object> getAdditionalProperties();

//	public void setAdditionalProperties(String name, Object value);

}