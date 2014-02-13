package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IMeal;
import de.hska.iwi.mgwt.demo.backend.constants.FoodAdditive;

public class Meal implements IMeal {
	
	private String name;
	private String priceAdditive;
	
	private double priceStudent;
	private double priceGuest;
	private double priceEmployee;
	private double pricePupil;
	
	private List<Integer> foodAdditiveNumbers;

	public Meal(IMeal iMeal) {
		this.name = iMeal.getName();
		this.priceAdditive = iMeal.getPriceAdditive();
		this.priceEmployee = iMeal.getPriceEmployee();
		this.priceGuest = iMeal.getPriceGuest();
		this.pricePupil = iMeal.getPricePupil();
		this.priceStudent = iMeal.getPriceStudent();
		this.foodAdditiveNumbers = iMeal.getFoodAdditiveNumbers();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the priceAdditive
	 */
	public String getPriceAdditive() {
		return priceAdditive;
	}

	/**
	 * @return the priceStudent
	 */
	public double getPriceStudent() {
		return priceStudent;
	}

	/**
	 * @return the priceGuest
	 */
	public double getPriceGuest() {
		return priceGuest;
	}

	/**
	 * @return the priceEmployee
	 */
	public double getPriceEmployee() {
		return priceEmployee;
	}

	/**
	 * @return the pricePupil
	 */
	public double getPricePupil() {
		return pricePupil;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param priceAdditive the priceAdditive to set
	 */
	public void setPriceAdditive(String priceAdditive) {
		this.priceAdditive = priceAdditive;
	}

	/**
	 * @param priceStudent the priceStudent to set
	 */
	public void setPriceStudent(double priceStudent) {
		this.priceStudent = priceStudent;
	}

	/**
	 * @param priceGuest the priceGuest to set
	 */
	public void setPriceGuest(double priceGuest) {
		this.priceGuest = priceGuest;
	}

	/**
	 * @param priceEmployee the priceEmployee to set
	 */
	public void setPriceEmployee(double priceEmployee) {
		this.priceEmployee = priceEmployee;
	}

	/**
	 * @param pricePupil the pricePupil to set
	 */
	public void setPricePupil(double pricePupil) {
		this.pricePupil = pricePupil;
	}
	
	/**
	 * @return the foodAdditiveNumbers
	 */
	public List<Integer> getFoodAdditiveNumbers() {
		return foodAdditiveNumbers;
	}

	/**
	 * @param foodAdditiveNumbers the foodAdditiveNumbers to set
	 */
	public void setFoodAdditiveNumbers(List<Integer> foodAdditiveNumbers) {
		this.foodAdditiveNumbers = foodAdditiveNumbers;
	}
	
	public List<FoodAdditive> getFoodAdditiveNumbersAsEnum() {
		ArrayList<FoodAdditive> result = new ArrayList<FoodAdditive>();
		for (int i : this.foodAdditiveNumbers) {
			
		}
		return result;
		
	}

}
