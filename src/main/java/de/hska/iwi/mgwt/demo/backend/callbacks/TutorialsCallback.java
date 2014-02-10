package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class TutorialsCallback extends AbstractRequestCallback<ObserverActivity<List<CourseTutorial>>>{

	public TutorialsCallback(ObserverActivity<List<CourseTutorial>> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		// TODO PARSE JSON etc
		//Ok
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}

}
