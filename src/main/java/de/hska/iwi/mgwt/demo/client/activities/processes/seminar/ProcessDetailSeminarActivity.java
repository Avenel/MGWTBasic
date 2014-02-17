package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowRoles;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowInformation;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailView;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;
import de.hska.iwi.mgwt.demo.client.storage.SeminarStorage;

/**
 * Activity for displaying a seminar Workflow.
 * In this activity, we need to get the statuses, a seminar can be in, from the intranet server.
 * After we got the data, it is cached in the local storage (Not currently).
 *
 */
public class ProcessDetailSeminarActivity extends MGWTAbstractActivity implements ObserverActivity<WorkflowInformation> {

	private ClientFactory clientFactory;
	private ProcessDetailView view;
	private Seminar seminar;
	private String id;
	private AcceptsOneWidget panel;

	public ProcessDetailSeminarActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}
	public ProcessDetailSeminarActivity(ClientFactory clientFactory, String id) {
		this.clientFactory = clientFactory;
		this.id = id;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.panel=panel;
		seminar = SeminarTempStorage.getSeminarList().get(Integer.parseInt(id));
		List<ProcessStep> steps= new ArrayList<ProcessStep>();
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		//TODO Case if Student is master or bachelor. In this Case student is always master
		intranetConn.getWorkflowInformation(this, WorkflowEvent.SEMINAR_MASTER);
		int activeStep=seminar.getStatus();
		//No steps in the local Storage, and the polling is running
		if(SeminarStorage.getSeminarSteps().isEmpty()){
			activeStep=0;
			steps.add(new ProcessStep("Datenabfrage...", 0, "Abfrage"));
		}else{
			steps=SeminarStorage.getSeminarSteps();
		}
		
		
		view = this.clientFactory.getProcessDetailView(activeStep, steps, Integer.parseInt(id));
		view.setTitle(seminar.getTopic());
		view.render();
		panel.setWidget(view);

		

	}
	@Override
	public void update(WorkflowInformation arg) {
		List<ProcessStep> steps= new ArrayList<ProcessStep>();
		for(int i=0; i<arg.getWorkflow().size();i++){
			List<WorkflowRoles> roles=arg.getRolesInPhase(WorkflowPhase.getEnumForKey(i));
			String desc= i+1 +". "+roles.get(0).getDescription();
			steps.add(new ProcessStep(desc, i, "desc"));
		}
		
		//set to persistent web storage
		SeminarStorage.setSeminarSteps(steps);
		view = this.clientFactory.getProcessDetailView(seminar.getStatus(), steps, Integer.parseInt(id));
		view.setTitle(seminar.getTopic());
		view.render();
		this.panel.setWidget(view);
	}

}
