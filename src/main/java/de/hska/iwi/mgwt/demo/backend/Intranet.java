package de.hska.iwi.mgwt.demo.backend;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowInformation;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public interface Intranet {
	
	public void getTutorials(ObserverActivity<List<CourseTutorial>> observer, Course course);
		
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException;
	
	public void getConsultationHours(ObserverActivity<List<ConsultationHour>> observer);
		
	public void getCompulsoryOptionalSubjects(ObserverActivity<List<CompulsoryOptionalSubjects>> observer, Course course) throws IllegalArgumentException;
	
	public void getMensaMenu(ObserverActivity<MensaMenu> observer, Canteen canteen, String date) throws IllegalArgumentException;
	
	public void getWorkflowInformation(ObserverActivity<WorkflowInformation> observer, WorkflowEvent event);

}
