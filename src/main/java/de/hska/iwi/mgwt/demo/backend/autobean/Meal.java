package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.FoodAdditive;

public interface Meal {

	public String getName();

	public void setName(String name);

	public Double getPriceStudent();

	public void setPriceStudent(Double priceStudent);

	public Double getPriceGuest();

	public void setPriceGuest(Double priceGuest);

	public Double getPriceEmployee();

	public void setPriceEmployee(Double priceEmployee);

	public Double getPricePupil();

	public void setPricePupil(Double pricePupil);

	public String getPriceAdditive();

	public void setPriceAdditive(String priceAdditive);

	public List<FoodAdditive> getFoodAdditiveNumbers();

	public void setFoodAdditiveNumbers(List<FoodAdditive> foodAdditiveNumbers);

//	public abstract Map<String, Object> getAdditionalProperties();

//	public abstract void setAdditionalProperties(String name, Object value);

}