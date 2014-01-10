package de.hska.iwi.mgwt.demo.backend.connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.callbacks.NewsBoardCallback;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class GWTIntranetConnection implements Intranet {
	
	private static final String BASE_URL = "http://www.iwi.hs-karlsruhe.de";
	
	private static final String TUTORIALS_ALL = "/Intranetaccess/REST/tutorials/";
	
	private static final String TUTORIALS = "/Intranetaccess/REST/tutorials/<stg>";
	
	private static final String CUMPOLSORY = "/Intranetaccess/REST/compulsoryoptionalsubjects/<stg>";
	
	private static final String NEWS_BOARD_ALL = "/Intranetaccess/REST/newsbulletinboard/";
	
	private static final String NEWS_BOARD = "/Intranetaccess/REST/newsbulletinboard/<stg>";
	
	private static final String LECTURER_HOURS = "/Intranetaccess/REST/lecturersconsultationhours/";
	
	private static final String BLOCK_COURSES = "/Intranetaccess/REST/blockcourses/<stg>";
	
	private static final String TIMETABLE = "/Intranetaccess/REST/timetable/<stg>/<sem>";
	
	private static final String WORKFLOW = "/Intranetaccess/REST/application/workflow/<veranst>";
	
	private static final String WORKFLOW_PROGRESS = "/Intranetaccess/REST/application/state/<veranst>";
	
	private static final String MENSA_MENU = "/Intranetaccess/REST/canteen/<id>/<date>";
	
	private static final String PARAM_PATTERN = "<.*>";
	

	
	public GWTIntranetConnection() {
		
	}

	@Override
	public List<CourseTutorial> getTutorials(Course course) {
		ArrayList<CourseTutorial> tutorial = null;
		String url = BASE_URL + TUTORIALS_ALL;
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
//		builder.setHeader("Accept", "application/json");
		
		try {
			Request response = builder.sendRequest(null, new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					int code = response.getStatusCode();
					String test = response.getText();
				}
				
				@Override
				public void onError(Request request, Throwable exception) {
							Throwable e = exception;			
				}
			});
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tutorial;
	}

	@Override
	public void getTutorials(ObserverActivity<List<CourseTutorial>> observer,
			Course course) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<NewsBoard> getNewsBoard(Course course)
			throws IllegalArgumentException {
		
		ArrayList<NewsBoard> retList = new ArrayList<NewsBoard>();
		
		NewsBoard v = new NewsBoard();
		ArrayList<Course> courses = new ArrayList<Course>();
		v = new NewsBoard();
		v.setId(50);
		v.setTitle("Technische Informatik 1 Übungen");
		v.setSubTitle("Ausfall");
		courses = new ArrayList<Course>();
		courses.add(Course.MEDIENINFORMATIK_BACHELOR);
		courses.add(Course.INFORMATIK_BACHELOR);
		v.setCourseOfStudies(courses);
		v.setContent("Die Veranstaltung am Donnerstag, dem 09.01.2014 entfällt.");
		v.setLinks(null);
		v.setType(NewsType.CANCELLATION);
		retList.add(v);

		return retList;
	}

	@Override
	public void getNewsBoard(ObserverActivity<List<NewsBoard>> observer, Course course) throws IllegalArgumentException {
		ArrayList<NewsBoard> retList = (ArrayList<NewsBoard>) getNewsBoard(course);
		
		String url = BASE_URL + "/Intranetaccess/REST/tutorials/INFB";
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		NewsBoardCallback cb = new NewsBoardCallback(observer);
		
		try {
			Request response = builder.sendRequest(null, cb);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ConsultationHour> getConsultationHours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getConsultationHours(
			ObserverActivity<List<ConsultationHour>> observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(
			Course course) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getCompulsoryOptionalSubjects(
			ObserverActivity<List<CompulsoryOptionalSubjects>> observer,
			Course course) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MensaMenu> getMensaMenu(int id, Date date) {
		String url = BASE_URL + TUTORIALS_ALL;
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setHeader("Accept", "application/json");
		
		try {
			Request response = builder.sendRequest(null, new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					int code = response.getStatusCode();
					String test = response.getText();
					
				}
				
				@Override
				public void onError(Request request, Throwable exception) {
					// TODO Auto-generated method stub
					
				}
			});
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
