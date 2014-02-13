package de.hska.iwi.mgwt.demo.backend.connection;

import java.util.List;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.URL;

import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.callbacks.CompulsorySubjectCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.MensaMenuCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.NewsBoardCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.TutorialsCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.WorkflowInformationCallback;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.backend.model.Tutorials;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowInformation;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.util.UrlBuilderUtil;
import de.hska.iwi.mgwt.demo.backend.util.UserCredentials;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class IntranetConnection implements Intranet {

	@Override
	public void getTutorials(ObserverActivity<Tutorials> observer, Course course) {
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
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException {
		if (observer == null || course == null) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		String url = UrlBuilderUtil.getNewsBoardUrl(course);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		NewsBoardCallback cb = new NewsBoardCallback(observer);
		
		try {
			builder.sendRequest(null, cb);
		} catch (RequestException e) {
			System.out.println("error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void getConsultationHours(ObserverActivity<List<ConsultationHour>> observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getCompulsoryOptionalSubjects(ObserverActivity<CompulsoryOptionalSubjects> observer, Course course)
													throws IllegalArgumentException {
		if (isParamNull(observer, course)) {
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
	public void getMensaMenu(ObserverActivity<MensaMenu> observer, Canteen canteen, String date) throws IllegalArgumentException {
		if (observer == null || canteen == null || date == null) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		String url = UrlBuilderUtil.getMensaUrl(canteen, date);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		MensaMenuCallback cb = new MensaMenuCallback(observer);
		
		try {
			builder.sendRequest(null, cb);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getWorkflowInformation(ObserverActivity<WorkflowInformation> observer, WorkflowEvent event) {
		if (isParamNull(observer, event)) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		
		String url = UrlBuilderUtil.getWorkflowInformationUrl(event);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		WorkflowInformationCallback cb = new WorkflowInformationCallback(observer);
		
		try {
			builder.sendRequest(null, cb);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private boolean isParamNull(Object... args) {
		for (Object obj : args) {
			if (obj == null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void getWorkflowStatus(ObserverActivity<WorkflowStatus> observer,
			WorkflowEvent event, UserCredentials credentials) {
		// TODO Auto-generated method stub
		
	}

	
}
