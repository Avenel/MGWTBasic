package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailView;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;

/**
 * Activity for displaying a seminar Workflow.
 * In this activity, we need to get the statuses, a seminar can be in, from the intranet server.
 * After we got the data, it is cached in the local storage (Not currently).
 *
 */
public class ProcessDetailSeminarActivity extends MGWTAbstractActivity	 {

	private ClientFactory clientFactory;
	private ProcessDetailView view;
	private Seminar seminar;
	private String id;

	public ProcessDetailSeminarActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}
	public ProcessDetailSeminarActivity(ClientFactory clientFactory, String id) {
		this.clientFactory = clientFactory;
		this.id = id;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		seminar = SeminarTempStorage.getSeminarList().get(Integer.parseInt(id));
		List<ProcessStep> steps= new ArrayList<ProcessStep>();
		
		int activeStep=seminar.getStatus();
		int i=0;
		for(WorkflowPhase p : WorkflowPhase.values()){
			steps.add(new ProcessStep(i+1+". "+p.getDescription(),i++));
		}
		String currentStatusString= steps.get(seminar.getStatus()).getDisplayText();
		currentStatusString+=": "+seminar.getStatusString();
		steps.set(seminar.getStatus(), new ProcessStep(currentStatusString,seminar.getStatus()));
		

		
		view = this.clientFactory.getProcessDetailView(activeStep, steps, Integer.parseInt(id));
		view.setTitle(seminar.getTopic());
		view.render();
		panel.setWidget(view);

		

	}
	

}
