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
import de.hska.iwi.mgwt.demo.backend.util.UserCredential;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

/**
 * Provides Functionality which handles the data for the application.
 * @author Nico
 */
public interface Intranet {
	
	/**
	 * This provides the information about all available Tutorials. Only particular tutorials could be requested with the course parameter.
	 * Calling this method will result in an Asynchronous call and the result will be pushed back into the provided observer.
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param course an {@link Course}-Enum for specifying which tutorials are requested. Course.ALL will request for every Course.
	 * @throws IllegalArgumentException if one of the arguments are null
	 */
	public void getTutorials(ObserverActivity<Tutorials> observer, Course course) throws IllegalArgumentException;
	
	/**
	 * Provides Information about the NewsBoard for the IWI-Faculty. Ccourse specifies which news are returned. This is 
	 * an Asynchronous-call where the ObserverActivity is used as a callback-object.
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param course an {@link Course}-Enum for specifying which tutorials are requested. Course.ALL will request for every Course.	
	 * @throws IllegalArgumentException if one of the arguments are null
	 */
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException;
	
	/**
	 * Provides all the information about the Consultationhours of the lecturers.
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @throws IllegalArgumentException if observer is null
	 */
	public void getConsultationHours(ObserverActivity<ConsultationHours> observer) throws IllegalArgumentException;
		
	/**
	 * Provides the information about the CompulsoryOptionalSubjects. Asynchronous call which uses the ObserverActivity
	 * as a Callback-object.
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param course {@link Course}-Enum, but Course.ALL is not allowed in this case. Will result in an Exception.
	 * @throws IllegalArgumentException if one parameter is null or course is Course.ALL, this is not allowed for this call.
	 */
	public void getCompulsoryOptionalSubjects(ObserverActivity<CompulsoryOptionalSubjects> observer, Course course) throws IllegalArgumentException;
	
	/**
	 * Provides information about the meals and additional Information about the meal, like Foodadditives. Is an Asynchronous call
	 * which uses the ObserverActivity as a callback. 
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param canteen a {@link Canteen}-Enum which Canteen you are looking for.
	 * @param date date must be in the following format yyyy-MM-dd. For this date the MensaMenu will returned
	 * @throws IllegalArgumentExceptionif one of the arguments is null or the date is malformed
	 */
	public void getMensaMenu(ObserverActivity<MensaMenu> observer, Canteen canteen, String date) throws IllegalArgumentException;
	
	/**
	 * This method provides general information about the Workflow of an Event. Events are for example a seminar in the Master course,
	 * and are specified in the {@link WorkflowEvent}-Enum. This call will start an asynchronoues call and push the result into
	 * the ObserverActivity.
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param event one of the {@link WorkflowEvent} enums, specifies for which event the information will be gathered.
	 * @throws IllegalArgumentException if one of the parameters is null
	 */
	public void getWorkflowInformation(ObserverActivity<WorkflowInformation> observer, WorkflowEvent event, Course course) throws IllegalArgumentException;
	
	/**
	 * Provides information about the actual Workflow for an given event and the given student. Gathers information what
	 * is the current step to do and some additional information, like the due date, start date etc. This method requires
	 * a valid user with an password by a given {@link UserCredential}. This will trigger an asynchronous call.
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param event The event for which the information will be gathered. 
	 * @param credentials the user with the password for this call.
	 * @throws IllegalArgumentException if one of the arguments is null.
	 */
	public void getWorkflowStatus(ObserverActivity<WorkflowStatus> observer, WorkflowEvent event, UserCredential credentials) throws IllegalArgumentException;
	
	/**
	 * Provides information about the Blockcourses for the given course. If Course.All is choosen, then all available
	 * BlockCourses are returned. An asynchronous call is triggered and the ObserverActivity is the callback for the result. 
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param course specifies for which course the Information is gathered
	 * @throws IllegalArgumentException if one of the parameters is null.
	 */
	public void getBlockCourses(ObserverActivity<BlockCourses> observer, Course course) throws IllegalArgumentException;
	
	/**
	 * Provides information about the Timetable of a given course and a given Semester. Course.All is invalid in this case,
	 * and semester has to be between 1-7 for any Bacehlor-Course and 1-3 for any Master-Course.
	 * 
	 * @param observer implementation of an {@link ObserverActivity} where the result will be pushed back to the caller.
	 * @param course all {@link Course}-Enums instead of Course.ALL.
	 * @param semester value which specifies which semester is requested. Valid range. 1-7 for Bachelor and 1-3 for Matser
	 * @throws IllegalArgumentException if one argument is null or course is not valid or semester is not in a valid range.
	 */
	public void getTimetable(ObserverActivity<Timetable> observer, Course course, int semester) throws IllegalArgumentException;
	
}
