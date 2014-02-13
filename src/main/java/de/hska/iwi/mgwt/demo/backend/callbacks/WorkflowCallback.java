package de.hska.iwi.mgwt.demo.backend.callbacks;

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
	protected void handleJson(String json) {
		AutoBean<IWorkflowInformation> bean = AutoBeanCodex.decode(factory, IWorkflowInformation.class, json);
		
		WorkflowInformation info = new WorkflowInformation(bean.as());
		
		observer.update(info);
	}

}
