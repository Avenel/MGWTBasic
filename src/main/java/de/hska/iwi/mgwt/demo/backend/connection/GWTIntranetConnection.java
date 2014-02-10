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
import de.hska.iwi.mgwt.demo.backend.callbacks.AbstractRequestCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.CompulsorySubjectCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.MensaMenuCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.NewsBoardCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.TutorialsCallback;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.backend.util.UrlBuilderUtil;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class GWTIntranetConnection implements Intranet {
	
	@Override
	public List<CourseTutorial> getTutorials(Course course) {
		return new ArrayList<CourseTutorial>();
	}

	@Override
	public void getTutorials(ObserverActivity<List<CourseTutorial>> observer, Course course) {
		if (observer == null || course == null) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		String url = UrlBuilderUtil.getTutorialsUrl(course);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		TutorialsCallback cb = new TutorialsCallback(observer);
		
		try {
			builder.sendRequest(null, cb);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<News> getNewsBoard(Course course) throws IllegalArgumentException {
		
		ArrayList<News> retList = new ArrayList<News>();
		
		News v = new News();
		ArrayList<Course> courses = new ArrayList<Course>();
		v = new News();
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
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException {
		if (observer == null || course == null) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		String url = UrlBuilderUtil.getNewsBoardUrl(course);
		
		System.out.println("url: " + url);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		NewsBoardCallback cb = new NewsBoardCallback(observer);
		
		try {
			System.out.println("request!");
			Request request = builder.sendRequest(null, cb);
		} catch (RequestException e) {
			System.out.println("error");
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
	public void getConsultationHours(ObserverActivity<List<ConsultationHour>> observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(Course course) throws IllegalArgumentException {
		return new ArrayList<CompulsoryOptionalSubjects>();
	}

	@Override
	public void getCompulsoryOptionalSubjects(ObserverActivity<List<CompulsoryOptionalSubjects>> observer, Course course)
													throws IllegalArgumentException {
		if (observer == null || course == null) {
			throw new IllegalArgumentException("Parameter must not be null");
		} else if (Course.ALL == course) {
			throw new IllegalArgumentException("This course is not allowed");
		}
		String url = UrlBuilderUtil.getCumpolsoryUrl(course);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		CompulsorySubjectCallback cb = new CompulsorySubjectCallback(observer);
		
		try {
			builder.sendRequest(null, cb);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MensaMenu> getMensaMenu(int id, Date date) {
		String url = "http://www.iwi.hs-karlsruhe.de/Intranetaccess/REST/tutorials/";
		
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

	@Override
	public void getMensaMenu(ObserverActivity<List<MensaMenu>> observer, Canteen canteen, Date date) throws IllegalArgumentException {
		if (observer == null || canteen == null || date == null) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		String url = UrlBuilderUtil.getMensaUrl(canteen, date);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		MensaMenuCallback cb = new MensaMenuCallback(observer);
		
		try {
			builder.sendRequest(url, cb);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
