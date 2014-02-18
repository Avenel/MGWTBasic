package de.hska.iwi.mgwt.demo.backend;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.model.BlockCourses;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHours;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.backend.model.Timetable;
import de.hska.iwi.mgwt.demo.backend.model.Tutorials;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowInformation;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.util.UserCredentials;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public interface Intranet {
	
	public void getTutorials(ObserverActivity<Tutorials> observer, Course course) throws IllegalArgumentException;
		
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException;
	
	public void getConsultationHours(ObserverActivity<ConsultationHours> observer) throws IllegalArgumentException;
		
	public void getCompulsoryOptionalSubjects(ObserverActivity<CompulsoryOptionalSubjects> observer, Course course) throws IllegalArgumentException;
	
	public void getMensaMenu(ObserverActivity<MensaMenu> observer, Canteen canteen, String date) throws IllegalArgumentException;
	
	public void getWorkflowInformation(ObserverActivity<WorkflowInformation> observer, WorkflowEvent event) throws IllegalArgumentException;
	
	public void getWorkflowStatus(ObserverActivity<WorkflowStatus> observer, WorkflowEvent event, UserCredentials credentials) throws IllegalArgumentException;
	
	public void getBlockCourses(ObserverActivity<BlockCourses> observer, Course course) throws IllegalArgumentException;
	
	public void getTimetable(ObserverActivity<Timetable> observer, Course course, int semester) throws IllegalArgumentException;

}
