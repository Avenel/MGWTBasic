package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;
import java.util.Map;

public interface ICompulsoryOptionalSubjects {

	public Map<String, List<ICompulsoryOptionalSubject>> getCompulsorySubjects();
	
	public void setCompulsorySubjects(Map<String, List<ICompulsoryOptionalSubject>> subjects);
}
