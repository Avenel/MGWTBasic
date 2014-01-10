package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class CompulsorySubjectCallback extends AbstractRequestCallback<ObserverActivity<List<CompulsoryOptionalSubjects>>> {

	public CompulsorySubjectCallback(ObserverActivity<List<CompulsoryOptionalSubjects>> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		// TODO Parse JSON ETC
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}
	

}
