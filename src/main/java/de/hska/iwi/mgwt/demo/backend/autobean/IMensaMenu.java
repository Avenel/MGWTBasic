package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.CanteenStatus;

public interface IMensaMenu {
	/**
	 * @return name of the Menu
	 */
	public String getName();
	/**
	 * @return list of {@link IMealGroup}
	 */
	public List<IMealGroup> getMealGroups();
	/**
	 * @return the status of the Mensa.
	 */
	public CanteenStatus getMensaStatus();
	/**
	 * @return the date of this meal
	 */
	public String getDate();
}
