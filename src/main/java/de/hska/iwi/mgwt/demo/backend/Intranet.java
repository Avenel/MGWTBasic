package de.hska.iwi.mgwt.demo.backend;

import java.util.Date;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public interface Intranet {
	
	/**
	 * 
	 * @deprecated Please use the corresponding method with an observer.
	 */
	@Deprecated
	public List<CourseTutorial> getTutorials(Course course);
	
	public void getTutorials(ObserverActivity<List<CourseTutorial>> observer, Course course);
	
	/**
	 * 
	 * @deprecated Please use the corresponding method with an observer.
	 */
	@Deprecated
	public List<News> getNewsBoard(Course course) throws IllegalArgumentException;
	
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException;
	
	/**
	 * 
	 * @deprecated Please use the corresponding method with an observer.
	 */
	@Deprecated
	public List<ConsultationHour> getConsultationHours();
	
	public void getConsultationHours(ObserverActivity<List<ConsultationHour>> observer);
	
	/**
	 * 
	 * @deprecated Please use the corresponding method with an observer.
	 */
	@Deprecated
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(Course course) throws IllegalArgumentException;
	
	public void getCompulsoryOptionalSubjects(ObserverActivity<List<CompulsoryOptionalSubjects>> observer, Course course) throws IllegalArgumentException;
	
	/**
	 * 
	 * @deprecated Please use the corresponding method with an observer.
	 */
	@Deprecated
	public List<MensaMenu> getMensaMenu(int id, Date date);
	
	public void getMensaMenu(ObserverActivity<List<MensaMenu>> observer, Canteen canteen, Date date) throws IllegalArgumentException;;

}
