package de.hska.iwi.mgwt.demo.backend.requestcallbacks;

import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class NewsBoardCallback implements RequestCallback {

	private List<NewsBoard> newsBoard = null;
	
	private static ObserverActivity<List<NewsBoard>> observer;
	
	public NewsBoardCallback(ObserverActivity<List<NewsBoard>> observer) {
		this.observer = observer;
	}
	
	@Override
	public void onResponseReceived(Request request, Response response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}

}
