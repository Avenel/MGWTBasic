package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.RequestCallback;

import de.hska.iwi.mgwt.demo.backend.gwt.CustomBeanFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public abstract class AbstractRequestCallback<T extends ObserverActivity<?>> implements RequestCallback{
	
	protected final T observer;
	
	protected final CustomBeanFactory factory;
	
	public AbstractRequestCallback(T observer) {
		this.observer = observer;
		factory = (CustomBeanFactory) GWT.create(CustomBeanFactory.class);
	}
	
}
