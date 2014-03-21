package de.hska.iwi.mgwt.demo.backend.util;

import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;

/**
 * Util class which constructs the Urls for the REST-API calls.
 * @author Nico
 *
 */
public class UrlBuilderUtil {
	
	private static final String BASE_URL = "http://www.iwi.hs-karlsruhe.de/Intranetaccess/REST";
	private static final String BASE_URL_SECURE = "https://www.iwi.hs-karlsruhe.de/Intranetaccess/REST";
	
	private static final String TUTORIALS_ALL = "/tutorials/";
	
	private static final String CUMPOLSORY = "/compulsoryoptionalsubjects/";
	
	private static final String NEWS_BOARD_ALL = "/newsbulletinboard/";
	
	private static final String LECTURER_HOURS = "/lecturersconsultationhours/";
	
	private static final String BLOCK_COURSES = "/blockcourses/";
	
	private static final String TIMETABLE = "/timetable/";
	
	private static final String WORKFLOW_INFORMATION = "/application/workflow/";
	
	private static final String WORKFLOW_STATUS = "/application/state/";
	
	private static final String MENSA_MENU = "/canteen/";
	
	/**
	 * Builds an Url (String) regarding the given parameters for getting the MensaMenu.
	 * 
	 * @param canteen the requested ·{@link Canteen}
	 * @param date the date for the request.
	 * @return the url as a String for the request.
	 */
	public static String getMensaUrl(Canteen canteen, String date) {
		return BASE_URL + MENSA_MENU + canteen.getUrlKey() +  "/" + date;
	}
	
	/**
	 * Builds an Url (String) regarding the given parameters for getting the CompulsoryOptionalSubjects.
	 * 
	 * @param course the {@link Course} for which the cumpolsorySubjects are requested
	 * @return the url as a String for the request.
	 */
	public static String getCumpolsoryUrl(Course course) {
		return BASE_URL + CUMPOLSORY + course.getUrlKey();
	}
	
	public static String getTutorialsUrl(Course course) {
		String url = "";
		switch (course) {
			case ALL:
				url = BASE_URL + TUTORIALS_ALL;
				break;
			default:
				url = BASE_URL + TUTORIALS_ALL + course.getUrlKey();	
				break;
		}
		return url;	
	}
	
	/**
	 * Builds an Url (String) regarding the given parameters for getting the NewsBoard.
	 * 
	 * @param course the {@link Course} for which the newsBulletinBoard is requested
	 * @return the url as a String for the request.
	 */
	public static String getNewsBoardUrl(Course course) {
		String url = "";
		switch (course) {
			case ALL:
				url = BASE_URL + NEWS_BOARD_ALL;
				break;
			default:
				url = BASE_URL + NEWS_BOARD_ALL + course.getUrlKey();	
		}
		return url;	
	}
	
	/**
	 * Builds an Url (String) regarding the given parameters for getting the WorkflowInformation.
	 * 
	 * @param workflowEvent the event for which the Information shall be received
	 * @return the url as a String for the request.
	 */
	public static String getWorkflowInformationUrl(WorkflowEvent workflowEvent, Course course) {
		return BASE_URL + WORKFLOW_INFORMATION + course.getUrlKey() + "/" +  workflowEvent.getUrlKey();
	}
	
	/**
	 * Builds an Url (String) regarding the given parameters for getting the WorkflowStatus.
	 * 
	 * @param workflowEvent the event for which the status shall be received
	 * @return the url as a String for the request.
	 */
	public static String getWorkflowStatusUrl(WorkflowEvent workflowEvent) {
		System.out.println(BASE_URL_SECURE + WORKFLOW_STATUS + workflowEvent.getUrlKey());
		return BASE_URL_SECURE + WORKFLOW_STATUS + workflowEvent.getUrlKey();
	}

	/**
	 * Builds an Url (String) for getting the ConsultationHours.
	 * 
	 * @return the url as a String for the request.
	 */
	public static String getConsultationHoursUrl() {
		return BASE_URL + LECTURER_HOURS;
	}
	
	/**
	 * Builds an Url (String) for getting the BlockCourses.
	 * 
	 * @param course the {@link Course} for which the BlockCourses are requested.
	 * @return the url as a String for the request.
	 */
	public static String getBlockCoursesUrl(Course course) {
		String url = "";
		switch (course) {
			case ALL:
				url = BASE_URL + BLOCK_COURSES;
				break;
			default:
				url = BASE_URL + BLOCK_COURSES + course.getUrlKey();
		}
		return url;
	}

	/**
	 * Builds an Url (String) regarding the given parameters for getting the TimeTable
	 * 
	 * @param course a {@link Course} for which the timetable is requested
	 * @param semester the semester which is requested
	 * @return the url for the Timetable
	 */
	public static String getTimetableUrl(Course course, int semester) {
		return BASE_URL + TIMETABLE + course.getUrlKey() + "/" + semester;
	}

}
