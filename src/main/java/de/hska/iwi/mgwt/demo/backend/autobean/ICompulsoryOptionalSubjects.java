package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;
import java.util.Map;
/**
 * Interface for a model type of an ICompulsoryOptionalSubjects. This Interface is necessary for the GWT AutoBean creation.
 * @author Nico
 *
 */
public interface ICompulsoryOptionalSubjects {

	/**
	 * @return map of the compulsorySubjects
	 */
	public Map<String, List<ICompulsoryOptionalSubject>> getCompulsorySubjects();
	
	/**
	 * @param subjects the compulsoryOptionalsubjects to set
	 */
	public void setCompulsorySubjects(Map<String, List<ICompulsoryOptionalSubject>> subjects);
}
