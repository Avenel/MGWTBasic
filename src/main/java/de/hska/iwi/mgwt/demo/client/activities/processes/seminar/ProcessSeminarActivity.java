package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.util.UserCredentials;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailPlace;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarStorage;
import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class ProcessSeminarActivity extends MGWTAbstractActivity implements ObserverActivity<WorkflowStatus>  {

	private ClientFactory clientFactory;
	private ProcessSeminarView view;
	private List<Seminar> seminarEntries;
	private Storage localStorage;
	private String pWord= null;
	boolean added= false;

	public ProcessSeminarActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}

	private List<Seminar> generateSeminarEntriesFromJSON(String item) {
		List<Seminar> retVal = new ArrayList<Seminar>();
		try {
			JSONValue value = JSONParser.parseStrict(item);
			JSONArray storageContents = (JSONArray) value;
			for (int i = 0; i < storageContents.size(); i++) {

				JSONObject currentObject = (JSONObject) storageContents.get(i);
				Seminar seminar = new Seminar();
				String professor=currentObject.get(StorageKey.ProcessesSeminarProfessor.toString()).toString();
				professor= professor.replace("\"", "");
				seminar.setProfessor(professor);
				String term= currentObject.get(StorageKey.ProcessesSeminarTerm.toString()).toString();
				term= term.replace("\"", "");
				seminar.setTerm(term);
				String topic= currentObject.get(StorageKey.ProcessesSeminarTopic.toString()).toString();
				topic= topic.replace("\"", "");
				seminar.setTopic(topic);
				String status= currentObject.get(StorageKey.ProcessesSeminarStatus.toString()).toString();
				status= status.replace("\"", "");
				seminar.setStatus(Integer.parseInt(status));
				
				retVal.add(seminar);

			}
		} catch (NullPointerException e) {
			return retVal;
		}

		return retVal;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getProcessSeminarView();
		
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		if(pWord== null){
			pWord=Window.prompt("Enter Password", "password");
		}
		UserCredentials credentials= new UserCredentials("scsi1024", pWord);
		intranetConn.getWorkflowStatus(this, WorkflowEvent.SEMINAR_MASTER, credentials);
		localStorage = Storage.getLocalStorageIfSupported();

		seminarEntries = generateSeminarEntriesFromJSON(localStorage.getItem(StorageKey.ProcessesSeminarsList
				.toString()));
		SeminarTempStorage.setSeminars(seminarEntries);

		

		view.render(seminarEntries);
		panel.setWidget(view);

		addHandlerRegistration(view.getRegisterButton().addTapHandler(new TapHandler() {

			@Override
			public void onTap(TapEvent event) {
				RegisterSeminarPlace registerSeminarPlace = new RegisterSeminarPlace();
				clientFactory.getPlaceController().goTo(registerSeminarPlace);
			}
		}));
		addHandlerRegistration(view.getSeminarCellList().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				ProcessDetailPlace seminarProcessDetailPlace = new ProcessDetailPlace(event.getIndex() + "");
				clientFactory.getPlaceController().goTo(seminarProcessDetailPlace);
			}

		}));

	}

	@Override
	public void update(WorkflowStatus arg) {
		System.out.println(arg.getPhaseDescription());
		System.out.println(arg.getPhaseString());
		Seminar seminar= new Seminar();
		seminar.setProfessor("##liveData##");
		seminar.setStatus(arg.getPhase().getIndex());
		seminar.setTerm("##liveData##");
		seminar.setTopic("##liveData##");	
		seminarEntries.add(seminar);
		SeminarTempStorage.setSeminars(seminarEntries);
		view.render(seminarEntries);
		
	}

}
