package de.hska.iwi.mgwt.demo.backend;

import java.util.Date;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public interface Intranet {
	
	public List<CourseTutorial> getTutorials(Course course);
	
	public void getTutorials(ObserverActivity<List<CourseTutorial>> observer, Course course);
	
	public List<NewsBoard> getNewsBoard(Course course) throws IllegalArgumentException;
	
	public void getNewsBoard(ObserverActivity<List<NewsBoard>> observer, Course course) throws IllegalArgumentException;
	
	public List<ConsultationHour> getConsultationHours();
	
	public void getConsultationHours(ObserverActivity<List<ConsultationHour>> observer);
	
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(Course course) throws IllegalArgumentException;
	
	public void getCompulsoryOptionalSubjects(ObserverActivity<List<CompulsoryOptionalSubjects>> observer, Course course) throws IllegalArgumentException;
	
	public List<MensaMenu> getMensaMenu(int id, Date date);

}
