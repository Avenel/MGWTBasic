package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.IWorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowStatus;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class WorkflowStatusCallback extends AbstractRequestCallback<ObserverActivity<WorkflowStatus>> {

	public WorkflowStatusCallback(ObserverActivity<WorkflowStatus> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<IWorkflowStatus> bean = AutoBeanCodex.decode(factory, 
															  IWorkflowStatus.class,
															  json);
		observer.update(new WorkflowStatus(bean.as()));
	}


}
