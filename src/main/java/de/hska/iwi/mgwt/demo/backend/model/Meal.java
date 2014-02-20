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
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPriceAdditive() {
		return priceAdditive;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPriceStudent() {
		return priceStudent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPriceGuest() {
		return priceGuest;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPriceEmployee() {
		return priceEmployee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPricePupil() {
		return pricePupil;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPriceAdditive(String priceAdditive) {
		this.priceAdditive = priceAdditive;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPriceStudent(double priceStudent) {
		this.priceStudent = priceStudent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPriceGuest(double priceGuest) {
		this.priceGuest = priceGuest;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPriceEmployee(double priceEmployee) {
		this.priceEmployee = priceEmployee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPricePupil(double pricePupil) {
		this.pricePupil = pricePupil;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> getFoodAdditiveNumbers() {
		return foodAdditiveNumbers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFoodAdditiveNumbers(List<Integer> foodAdditiveNumbers) {
		this.foodAdditiveNumbers = foodAdditiveNumbers;
	}
	/**
	 * Converts the integers of the Foodadditive number to a corresponding {@link FoodAdditive}-Enum.
	 * @return list with the enums
	 */
	public List<FoodAdditive> getFoodAdditiveNumbersAsEnum() {
		ArrayList<FoodAdditive> result = new ArrayList<FoodAdditive>();
		for (int number : this.foodAdditiveNumbers) {
			result.add(FoodAdditive.getEnumForKey(number));
		}
		return result;
	}

}
