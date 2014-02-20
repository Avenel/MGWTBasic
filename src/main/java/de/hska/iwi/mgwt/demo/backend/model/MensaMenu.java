package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IMealGroup;
import de.hska.iwi.mgwt.demo.backend.autobean.IMensaMenu;
import de.hska.iwi.mgwt.demo.backend.constants.CanteenStatus;

/**
 * Model which holds information about a MensaMenu. The name, date and the MealGroups.
 * @author Nico
 *
 */
public class MensaMenu {

	private String name;
	private String date;
	
	private List<MealGroup> mealGroups;
	
	private CanteenStatus status;
	
	/**
	 * C'tor which creates a deep copy of the given Interface type.
	 * @param mensaMenu the given interface implementation type.
	 */
	public MensaMenu(IMensaMenu mensaMenu) {
		this.name = mensaMenu.getName();
		this.status = mensaMenu.getMensaStatus();
		this.date = mensaMenu.getDate();
		mealGroups = new ArrayList<MealGroup>();
		for (IMealGroup group : mensaMenu.getMealGroups()) {
			mealGroups.add(new MealGroup(group));
		}
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the mealGroups
	 */
	public List<MealGroup> getMealGroups() {
		return mealGroups;
	}

	/**
	 * @return the status
	 */
	public CanteenStatus getStatus() {
		return status;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param mealGroups the mealGroups to set
	 */
	public void setMealGroups(List<MealGroup> mealGroups) {
		this.mealGroups = mealGroups;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(CanteenStatus status) {
		this.status = status;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
