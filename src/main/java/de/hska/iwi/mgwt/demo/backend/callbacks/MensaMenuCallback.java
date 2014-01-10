package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class MensaMenuCallback extends AbstractRequestCallback<ObserverActivity<List<MensaMenu>>> {

	public MensaMenuCallback(ObserverActivity<List<MensaMenu>> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		// TODO PARSE JSON etc.
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}

}
