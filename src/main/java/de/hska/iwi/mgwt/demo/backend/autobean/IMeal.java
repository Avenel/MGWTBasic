package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface IMeal {

	/**
	 * @return the name
	 */
	public String getName();
	/**
	 * @param name the name to set
	 */
	public void setName(String name);
	/**
	 * @return the priceStudent
	 */
	public double getPriceStudent();
	/**
	 * @param priceStudent the priceStudent to set
	 */
	public void setPriceStudent(double priceStudent);
	/**
	 * @return the priceGuest
	 */
	public double getPriceGuest();
	/**
	 * @param priceGuest the priceGuest to set
	 */
	public void setPriceGuest(double priceGuest);
	/**
	 * @return the priceEmployee
	 */
	public double getPriceEmployee();
	/**
	 * @param priceEmployee the priceEmployee to set
	 */
	public void setPriceEmployee(double priceEmployee);
	/**
	 * @return the pricePupil
	 */
	public double getPricePupil();
	/**
	 * @param pricePupil the pricePupil to set
	 */
	public void setPricePupil(double pricePupil);
	/**
	 * @return the priceAdditive
	 */
	public String getPriceAdditive();
	/**
	 * @param priceAdditive the priceAdditive to set
	 */
	public void setPriceAdditive(String priceAdditive);
	/**
	 * @return the foodAdditiveNumbers
	 */
	public List<Integer> getFoodAdditiveNumbers();
	
	/**
	 * @param foodAdditiveNumbers the foodAdditiveNumbers to set
	 */
	public void setFoodAdditiveNumbers(List<Integer> foodAdditiveNumbers);
}