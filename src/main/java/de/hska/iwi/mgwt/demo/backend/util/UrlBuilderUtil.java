package de.hska.iwi.mgwt.demo.backend.util;

import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;

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
	
	
	public static String getMensaUrl(Canteen canteen, String date) {
		return BASE_URL + MENSA_MENU + canteen.getUrlKey() +  "/" + date;
	}
	
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
	
	public static String getWorkflowInformationUrl(WorkflowEvent workflowEvent) {
		return BASE_URL + WORKFLOW_INFORMATION + workflowEvent.getUrlKey();
	}
	
	public static String getWorkflowStatusUrl(WorkflowEvent workflowEvent) {
		return BASE_URL_SECURE + WORKFLOW_STATUS + workflowEvent.getUrlKey();
	}

	public static String getConsultationHoursUrl() {
		return BASE_URL + LECTURER_HOURS;
	}
	
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

	public static String getTimetableUrl(Course course, int semester) {
		return BASE_URL + TIMETABLE + course.getUrlKey() + "/" + semester;
	}

}
