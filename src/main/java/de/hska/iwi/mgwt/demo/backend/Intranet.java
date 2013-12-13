package de.hska.iwi.mgwt.demo.backend;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;

public interface Intranet {
	
	public List<CourseTutorial> getTutorials(Course course);
	
	public List<NewsBoard> getNewsBoard(Course course) throws IllegalArgumentException;
	
	public List<ConsultationHour> getConsultationHours();
	
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(Course course) throws IllegalArgumentException;

}
