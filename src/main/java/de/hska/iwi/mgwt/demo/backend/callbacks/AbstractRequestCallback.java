package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

import de.hska.iwi.mgwt.demo.backend.autobean.CustomBeanFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public abstract class AbstractRequestCallback<T extends ObserverActivity<?>> implements RequestCallback{
	
	protected final T observer;
	
	protected final CustomBeanFactory factory;
	
	public AbstractRequestCallback(T observer) {
		this.observer = observer;
		factory = (CustomBeanFactory) GWT.create(CustomBeanFactory.class);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getStatusCode() == 200) {
			handleJson(response.getText());
		}
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		System.out.println(exception);
		
	}
	
	protected abstract void handleJson(String json);
	
}
