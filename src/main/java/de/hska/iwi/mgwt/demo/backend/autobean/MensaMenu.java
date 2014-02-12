package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.MensaStatus;

public interface MensaMenu {

	public String getName();
	
	public List<MealGroup> getMealGroup();
	
	public MensaStatus getMensaStatus();
	
	public String getDate();
}
