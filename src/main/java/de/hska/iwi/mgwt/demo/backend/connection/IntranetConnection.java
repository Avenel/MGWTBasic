package de.hska.iwi.mgwt.demo.backend.connection;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.URL;
import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;

import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.callbacks.AbstractRequestCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.BlockCoursesCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.CompulsorySubjectCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.ConsultationHoursCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.MensaMenuCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.NewsBoardCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.TimetableCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.TutorialsCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.WorkflowInformationCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.WorkflowStatusCallback;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.exception.FailedRequestException;
import de.hska.iwi.mgwt.demo.backend.model.BlockCourses;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHours;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.backend.model.Timetable;
import de.hska.iwi.mgwt.demo.backend.model.Tutorials;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowInformation;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.util.UrlBuilderUtil;
import de.hska.iwi.mgwt.demo.backend.util.UserCredential;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

/**
 * Implementation of {@link Intranet}. This class handles the calls to a REST-API.
 * @author Nico
 *
 */
public class IntranetConnection implements Intranet {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getTutorials(ObserverActivity<Tutorials> observer, Course course) {
		throwIfNull(observer, course);

		String url = UrlBuilderUtil.getTutorialsUrl(course);
		
		TutorialsCallback cb = new TutorialsCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException {
		throwIfNull(observer, course);
		
		String url = UrlBuilderUtil.getNewsBoardUrl(course);
		
		NewsBoardCallback cb = new NewsBoardCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getCompulsoryOptionalSubjects(ObserverActivity<CompulsoryOptionalSubjects> observer, Course course)
													throws IllegalArgumentException {
		throwIfNull(observer, course);
			
		if (Course.ALL == course) {
			throw new IllegalArgumentException("This course is not allowed");
		}
		String url = UrlBuilderUtil.getCumpolsoryUrl(course);
		
		CompulsorySubjectCallback cb = new CompulsorySubjectCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getConsultationHours(ObserverActivity<ConsultationHours> observer) {
		throwIfNull(observer);
		
		String url = UrlBuilderUtil.getConsultationHoursUrl();
		
		ConsultationHoursCallback cb = new ConsultationHoursCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getMensaMenu(ObserverActivity<MensaMenu> observer, Canteen canteen, String date) throws IllegalArgumentException {
		throwIfNull(observer, canteen, date);
		String datePattern = "\\d{4}-\\d{2}-\\d{2}";
		
		if (!date.matches(datePattern)) {
			throw new IllegalArgumentException("Malformed date, must be in the following format: yyyy-MM-dd");
		}
		
		String url = UrlBuilderUtil.getMensaUrl(canteen, date);
		
		MensaMenuCallback cb = new MensaMenuCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getWorkflowInformation(ObserverActivity<WorkflowInformation> observer, WorkflowEvent event, Course course) {
		throwIfNull(observer, event);
		
		String url = UrlBuilderUtil.getWorkflowInformationUrl(event, course);
		
		WorkflowInformationCallback cb = new WorkflowInformationCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getWorkflowStatus(ObserverActivity<WorkflowStatus> observer, WorkflowEvent event, UserCredential credentials) {
		throwIfNull(observer, event, credentials);
		
		final String AUTH_HEADER = "Authorization";
		final String CHARSET = "UTF-8";
		
		String url = UrlBuilderUtil.getWorkflowStatusUrl(event);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		String authString = credentials.getUsername() + ":" + credentials.getPassword();
		String auth = "";
		try {
			auth = new String(Base64.encode(authString.getBytes(CHARSET)));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		builder.setHeader(AUTH_HEADER, "Basic " + auth);
		
		WorkflowStatusCallback cb = new WorkflowStatusCallback(observer);
		builder.setCallback(cb);
		
		try {
			builder.send();
		} catch (RequestException e) {
			throw new FailedRequestException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getBlockCourses(ObserverActivity<BlockCourses> observer, Course course) {
		throwIfNull(observer, course);
		
		String url = UrlBuilderUtil.getBlockCoursesUrl(course);
		
		BlockCoursesCallback cb = new BlockCoursesCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getTimetable(ObserverActivity<Timetable> observer, Course course, int semester) throws IllegalArgumentException {
		throwIfNull(observer, course, semester);
		if (semester < 1 || semester >= course.getCountOfSemester()) {
			throw new IllegalArgumentException("Semester must be between 1 and " + course.getCountOfSemester() + ".\n Was actual: " + semester);
		} else if (course == Course.ALL) {
			throw new IllegalArgumentException("Course.ALL is invalid for this method, please specify a particular course");
		}
		
		String url = UrlBuilderUtil.getTimetableUrl(course, semester);
		
		TimetableCallback cb = new TimetableCallback(observer);
		
		doRequest(cb, RequestBuilder.GET, url);
	}
		
	private <T extends AbstractRequestCallback<?>> void doRequest(T callback, 
																  RequestBuilder.Method httpMethod,
																  String plainUrl) {
		RequestBuilder builder = new RequestBuilder(httpMethod, URL.encode(plainUrl));
		builder.setCallback(callback);
		
		try {
			builder.send();
		} catch (RequestException e) {
			throw new FailedRequestException(e);
		}
		
		
	}
	
	private void throwIfNull(Object... args) {
		for (Object obj : args) {
			if (obj == null) {
				throw new IllegalArgumentException("Parameter must not be null");
			}
		}
	}

}
