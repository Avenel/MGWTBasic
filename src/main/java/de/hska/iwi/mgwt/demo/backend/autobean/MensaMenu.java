package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.CanteenStatus;

public interface MensaMenu {

	public String getName();
	
	public List<MealGroup> getMealGroups();
	
	public CanteenStatus getMensaStatus();
	
	public String getDate();
}
