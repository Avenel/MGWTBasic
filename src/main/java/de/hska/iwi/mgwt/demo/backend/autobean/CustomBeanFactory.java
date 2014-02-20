package de.hska.iwi.mgwt.demo.backend.autobean;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
/**
 * Factory Interface for the GWT AutoBean-creation.
 * Specifies methods with type declarations, which are later on used to generate the JSON <-> Java mapping.
 * @author Nico
 *
 */
public interface CustomBeanFactory extends AutoBeanFactory {
	
	AutoBean<INewsBoard> newsBoard();
	AutoBean<INews> news();
	
	AutoBean<IMensaMenu> mensaMenu();
	AutoBean<IMealGroup> mealGroup();
	AutoBean<IMeal> meal();
	
	AutoBean<ITutorials> tutorials();
	AutoBean<ITutorial> tutorial();
	
	AutoBean<ICompulsoryOptionalSubjects> subjects();
	AutoBean<ICompulsoryOptionalSubject> subject();
	
	AutoBean<IWorkflowInformation> workflowInformation();
	
	AutoBean<IWorkflowStatus> workflowStatus();
	
	AutoBean<IConsultationHours> hours();
	AutoBean<IConsultationHour> hour();
	
	AutoBean<IBlockCourses> courses();
	AutoBean<IBlockCourse> course();
	
	AutoBean<ITimetable> timetable();
	AutoBean<ITimetableBlockCourse> blockCourse();
	AutoBean<ITimetableEntry> entry();
}
