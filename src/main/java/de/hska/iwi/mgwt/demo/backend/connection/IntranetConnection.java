package de.hska.iwi.mgwt.demo.backend.connection;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.server.Base64Utils;
import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;

import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.callbacks.CompulsorySubjectCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.MensaMenuCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.NewsBoardCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.TutorialsCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.WorkflowInformationCallback;
import de.hska.iwi.mgwt.demo.backend.callbacks.WorkflowStatusCallback;
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
	
	private static final String AUTH_HEADER = "Authorization";
	private static final String CHARSET = "UTF-8";

	@Override
	public void getTutorials(ObserverActivity<Tutorials> observer, Course course) {
		if (isParamNull(observer, course)) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		String url = UrlBuilderUtil.getTutorialsUrl(course);
		
		TutorialsCallback cb = new TutorialsCallback(observer);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setCallback(cb);
		
		try {
			builder.send();
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getNewsBoard(ObserverActivity<List<News>> observer, Course course) throws IllegalArgumentException {
		if (isParamNull(observer, course)) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		String url = UrlBuilderUtil.getNewsBoardUrl(course);
		
		NewsBoardCallback cb = new NewsBoardCallback(observer);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setCallback(cb);
		
		try {
			builder.send();
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
		
		CompulsorySubjectCallback cb = new CompulsorySubjectCallback(observer);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setCallback(cb);
		
		try {
			builder.send();
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
		
		MensaMenuCallback cb = new MensaMenuCallback(observer);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setCallback(cb);
		
		try {
			builder.send();
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
		
		WorkflowInformationCallback cb = new WorkflowInformationCallback(observer);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setCallback(cb);
		
		try {
			builder.send();
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void getWorkflowStatus(ObserverActivity<WorkflowStatus> observer, WorkflowEvent event, UserCredentials credentials) {
		if (isParamNull(observer, event, credentials)) {
			throw new IllegalArgumentException("Parameter must not be null");
		}
		
		String url = UrlBuilderUtil.getWorkflowStatusUrl(event);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		
		String authString = credentials.getUsername() + ":" + credentials.getPassword();
		String auth = "";
		try {
			auth = new String(Base64.encode(authString.getBytes(CHARSET)));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		builder.setHeader(AUTH_HEADER, "Basic " + auth);
		
		WorkflowStatusCallback cb = new WorkflowStatusCallback(observer);
		builder.setCallback(cb);
		builder.setRequestData(null);
		try {
			builder.send();
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

}
