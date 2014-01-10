package de.hska.iwi.mgwt.demo.backend.util;

import java.util.Date;

import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;

public class UrlBuilderUtil {
	
	private static final String BASE_URL = "http://www.iwi.hs-karlsruhe.de";
	
	private static final String TUTORIALS_ALL = "/Intranetaccess/REST/tutorials/";
	
	private static final String CUMPOLSORY = "/Intranetaccess/REST/compulsoryoptionalsubjects/";
	
	private static final String NEWS_BOARD_ALL = "/Intranetaccess/REST/newsbulletinboard/";
	
	private static final String LECTURER_HOURS = "/Intranetaccess/REST/lecturersconsultationhours/";
	
	private static final String BLOCK_COURSES = "/Intranetaccess/REST/blockcourses/<stg>";
	
	private static final String TIMETABLE = "/Intranetaccess/REST/timetable/<stg>/<sem>";
	
	private static final String WORKFLOW = "/Intranetaccess/REST/application/workflow/<veranst>";
	
	private static final String WORKFLOW_PROGRESS = "/Intranetaccess/REST/application/state/<veranst>";
	
	// Complete url Intranetaccess/REST/canteen/<id>/<date>
	private static final String MENSA_MENU = "/Intranetaccess/REST/canteen/";
	
	
	public static String getMensaUrl(Canteen canteen, Date date) {
		return BASE_URL + MENSA_MENU + canteen.getUrlKey() +  "/" + date.toString();
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
				break;
		}
		return url;	
	}

}
