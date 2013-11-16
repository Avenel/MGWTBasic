package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarStorage;

public class ProcessDetailSeminarActivity extends MGWTAbstractActivity {

	private ClientFactory clientFactory;
	private ProcessDetailSeminarView view;
	private List<ProcessStep> currentModel;
	private Seminar seminar;
	private String id;

	public ProcessDetailSeminarActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}
	public ProcessDetailSeminarActivity(ClientFactory clientFactory, String id) {
		this.clientFactory = clientFactory;
		this.id=id;

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		seminar=SeminarStorage.getSeminarList().get(Integer.parseInt(id));
		
		
		List<ProcessStep> steps= new ArrayList<ProcessStep>();
		steps.add(new ProcessStep("Anmeldung", 0, "Student meldet sich an"));
		steps.add(new ProcessStep("Erstgutachter", 1, "Zur Ansicht bei Erstgutachter"));
		steps.add(new ProcessStep("Zweitgutachter", 2, "Zur Ansicht bei Zweitgutachter"));
		steps.add(new ProcessStep("Sekretariat", 3, "Zur Ansicht bei Sekretariat"));
		steps.add(new ProcessStep("Leiter", 4, "Zur Ansicht beim Leiter der Veranstaltung"));
		steps.add(new ProcessStep("Ergebnisse hochladen", 5, "Bitte Ergebnisse hochladen"));
		steps.add(new ProcessStep("Note verfuegbar", 6, "Ihre Note kann eingesehen werden. Der Prozess ist abgeschlossen"));
		
		currentModel=steps;
		view = this.clientFactory.getProcessDetailSeminarView(seminar.getStatus(),currentModel);
		view.setTitle(seminar.getTopic());
		

		//seminarEntries = SeminarStorage.getSeminarList();
		
		view.render();
		panel.setWidget(view);

		addHandlerRegistration(view.getRegisterButton().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				RegisterSeminarPlace registerSeminarPlace = new RegisterSeminarPlace();
				clientFactory.getPlaceController().goTo(registerSeminarPlace);
				
			}
		})); 

	}

}
