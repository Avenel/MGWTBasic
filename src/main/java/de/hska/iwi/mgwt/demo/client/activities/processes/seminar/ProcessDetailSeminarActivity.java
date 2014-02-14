package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.connection.IntranetConnection;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowInformation;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailView;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;

public class ProcessDetailSeminarActivity extends MGWTAbstractActivity implements ObserverActivity<WorkflowInformation> {

	private ClientFactory clientFactory;
	private ProcessDetailView view;
	private List<ProcessStep> currentModel;
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
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		//TODO Case if Student is master or bachelor. In this Case student is always master
		intranetConn.getWorkflowInformation(this, WorkflowEvent.SEMINAR_MASTER);
		
		
		List<ProcessStep> steps= new ArrayList<ProcessStep>();
		steps.add(new ProcessStep("Anmeldung", 0, "Student meldet sich an"));
		steps.add(new ProcessStep("Erstgutachter", 1, "Zur Ansicht bei Erstgutachter"));
		steps.add(new ProcessStep("Zweitgutachter", 2, "Zur Ansicht bei Zweitgutachter"));
		steps.add(new ProcessStep("Sekretariat", 3, "Zur Ansicht bei Sekretariat"));
		steps.add(new ProcessStep("Leiter", 4, "Zur Ansicht beim Leiter der Veranstaltung"));
		steps.add(new ProcessStep("Ergebnisse hochladen", 5, "Bitte Ergebnisse hochladen"));
		steps.add(new ProcessStep("Note verfuegbar", 6, "Ihre Note kann eingesehen werden. Der Prozess ist abgeschlossen"));
		
		currentModel=steps;
		view = this.clientFactory.getProcessDetailView(seminar.getStatus(), currentModel, Integer.parseInt(id));
		view.setTitle(seminar.getTopic());
		

		
		
		view.render();
		panel.setWidget(view);

		

	}
	@Override
	public void update(WorkflowInformation arg) {
		List<ProcessStep> steps= new ArrayList<ProcessStep>();
		int i = 0;
		for(String s : arg.getWorkflow()){
			steps.add(new ProcessStep(s, i++, "desc"));
		}
		view.render(steps);
	}

}
