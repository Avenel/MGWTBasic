package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.IWorkflowInformation;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowInformation;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class WorkflowCallback extends AbstractRequestCallback<ObserverActivity<WorkflowInformation>>{

	public WorkflowCallback(ObserverActivity<WorkflowInformation> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getStatusCode() == 200) {
			AutoBean<IWorkflowInformation> bean = AutoBeanCodex.decode(factory, IWorkflowInformation.class, response.getText());
			
			WorkflowInformation info = new WorkflowInformation(bean.as());
			
			observer.update(info);
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}

}
