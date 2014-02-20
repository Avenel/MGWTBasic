package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface ITutorials {
	/**
	 * @return a list of ITutorials
	 */
	public List<ITutorial> getTutorials();
	
	/**
	 * @param tutorials value to set
	 */
	public void setTutorials(List<ITutorial> tutorials);

}
