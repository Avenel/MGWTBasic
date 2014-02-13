package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface IMeal {

	public String getName();

	public void setName(String name);

	public double getPriceStudent();

	public void setPriceStudent(double priceStudent);

	public double getPriceGuest();

	public void setPriceGuest(double priceGuest);

	public double getPriceEmployee();

	public void setPriceEmployee(double priceEmployee);

	public double getPricePupil();

	public void setPricePupil(double pricePupil);

	public String getPriceAdditive();

	public void setPriceAdditive(String priceAdditive);

	public List<Integer> getFoodAdditiveNumbers();

	public void setFoodAdditiveNumbers(List<Integer> foodAdditiveNumbers);

//	public abstract Map<String, Object> getAdditionalProperties();

//	public abstract void setAdditionalProperties(String name, Object value);

}