package de.hska.iwi.mgwt.demo.backend;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;

public interface Intranet {
	
	public List<CourseTutorial> getTutorials(Course course);
	
	// Needs to be changed... newsBoar is not really correct. It is a list of News.
	public List<NewsBoard> getNewsBoard(Course course);
	
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(Course course);

}
