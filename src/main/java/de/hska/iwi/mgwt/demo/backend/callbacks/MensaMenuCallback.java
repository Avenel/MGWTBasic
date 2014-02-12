package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.MensaMenu;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class MensaMenuCallback extends AbstractRequestCallback<ObserverActivity<MensaMenu>> {

	public MensaMenuCallback(ObserverActivity<MensaMenu> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		int code = response.getStatusCode();
		String text = response.getText();
		
		
		if (response.getStatusCode() == 200) {
			AutoBean<MensaMenu> bean = AutoBeanCodex.decode(factory, MensaMenu.class, response.getText());
			
			observer.update(bean.as());
		}
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}

}
