package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class ConsultationHoursCallback extends AbstractRequestCallback<ObserverActivity<List<ConsultationHour>>> {

	public ConsultationHoursCallback(ObserverActivity<List<ConsultationHour>> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		// TODO Parse JSON etc
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void handleJson(String json) {
		// TODO Auto-generated method stub
		
	}

}
