package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hska.iwi.mgwt.demo.backend.autobean.ICompulsoryOptionalSubject;
import de.hska.iwi.mgwt.demo.backend.autobean.ICompulsoryOptionalSubjects;

public class CompulsoryOptionalSubjects {
	
	private Map<String, List<CompulsoryOptionalSubject>> subjects;
	
	public CompulsoryOptionalSubjects(ICompulsoryOptionalSubjects iSubjects) {
		for (Map.Entry<String, List<ICompulsoryOptionalSubject>> entry : iSubjects.getCompulsorySubjects().entrySet()) {
			ArrayList<CompulsoryOptionalSubject> subjectsModel = new ArrayList<CompulsoryOptionalSubject>();
			
			for (ICompulsoryOptionalSubject iSubject : entry.getValue()) {
				subjectsModel.add(new CompulsoryOptionalSubject(iSubject));
			}
			subjects.put(entry.getKey(), subjectsModel);
		}
	}
	
	/**
	 * Returns a list of all available compulsory subjects in the given module.
	 * @param module name of the module, for example: "Ausgewählte Kapitel der Informatik 1"
	 * @return list of all found compulsory subjects
	 */
	public List<CompulsoryOptionalSubject> getCompulsorySubjectsOfModule(String module) {
		return subjects.get(module);
	}

	/**
	 * @return the subjects
	 */
	public Map<String, List<CompulsoryOptionalSubject>> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Map<String, List<CompulsoryOptionalSubject>> subjects) {
		this.subjects = subjects;
	}

}
