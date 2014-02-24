package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

import de.hska.iwi.mgwt.demo.backend.autobean.CustomBeanFactory;
import de.hska.iwi.mgwt.demo.backend.exception.FailedRequestException;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
/**
 * This class generalizes steps which are necessary for processing a asynchronous API-call and the AutoBean-Creation.
 * If a request is finished and went well, then the ObserverActivity is used to push the result back.
 * @author Nico
 *
 * @param <T> Implementation of an {@link ObserverActivity} which is used as a callback to the Frontend.
 */
public abstract class AbstractRequestCallback<T extends ObserverActivity<?>> implements RequestCallback{
	
	protected final T observer;
	
	protected final CustomBeanFactory factory;
	
	/**
	 * C'tor which initializes the observer Object as well as the AutoBeanFactory.
	 * @param observer
	 */
	public AbstractRequestCallback(T observer) {
		this.observer = observer;
		factory = (CustomBeanFactory) GWT.create(CustomBeanFactory.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getStatusCode() == 200) {
			handleJson(response.getText());
		} else {
			throw new FailedRequestException("Response was not the HTTP-Status 200");
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onError(Request request, Throwable exception) {
		throw new FailedRequestException("Something went wrong, while processing the request.");
	}
	/**
	 * Called when processing a request went well and the json is available. Then this json will passed to this method
	 * and delegated to the correct implementation.
	 * @param json the json of the Request, which was performed.
	 */
	protected abstract void handleJson(String json);
	
}
