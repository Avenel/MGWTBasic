package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.gwt.http.client.RequestCallback;

import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public abstract class AbstractRequestCallback<T extends ObserverActivity<?>> implements RequestCallback{
	
	protected final T observer;
	
	public AbstractRequestCallback(T observer) {
		super();
		this.observer = observer;
	}
	
}
