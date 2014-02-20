package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.model.WorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.util.UserCredential;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailPlace;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;
import de.hska.iwi.mgwt.demo.client.storage.SeminarStorage;
import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class ProcessSeminarActivity extends MGWTAbstractActivity implements
		ObserverActivity<WorkflowStatus> {

	private ClientFactory clientFactory;
	private ProcessSeminarView view;
	private List<Seminar> seminarEntries;

	public ProcessSeminarActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getProcessSeminarView();
		view.setLoading(true);

		Intranet intranetConn = (Intranet) BackendFactory
				.createIntranetInstance();
		// TODO Get Username and password from settings
		String username;
		String pWord=null;
		
		try{
			username= SettingStorage.getValue(StorageKey.IZAccountname, false);
		}catch(Exception e){
			username = Window.prompt("Enter Username", "username");
		}
		
		try {
			pWord = SettingStorage.getValue(StorageKey.IZAccountPassword, true);
		} catch (Exception e) {
			pWord = Window.prompt("Enter Password", "password");

		}

		
		UserCredential credentials = new UserCredential(username, pWord);
		// create entries of local storage- just for exemplaric use
		seminarEntries = SeminarStorage.getSeminars();
		SeminarTempStorage.setSeminars(seminarEntries);

		// get the seminar from hska intranet
		intranetConn.getWorkflowStatus(this, WorkflowEvent.SEMINAR_MASTER,
				credentials);

		view.render(seminarEntries);
		panel.setWidget(view);

		addHandlerRegistration(view.getRegisterButton().addTapHandler(
				new TapHandler() {

					@Override
					public void onTap(TapEvent event) {
						RegisterSeminarPlace registerSeminarPlace = new RegisterSeminarPlace();
						clientFactory.getPlaceController().goTo(
								registerSeminarPlace);
					}
				}));
		addHandlerRegistration(view.getSeminarCellList()
				.addCellSelectedHandler(new CellSelectedHandler() {

					@Override
					public void onCellSelected(CellSelectedEvent event) {
						ProcessDetailPlace seminarProcessDetailPlace = new ProcessDetailPlace(
								event.getIndex() + "");
						clientFactory.getPlaceController().goTo(
								seminarProcessDetailPlace);
					}

				}));

	}

	@Override
	public void update(WorkflowStatus arg) {
		// build a new Seminar
		view.setLoading(false);
		Seminar seminar = new Seminar();
		if(arg.getLecturer()!=null){
			seminar.setProfessor(arg.getLecturer());
			seminar.setStatus(arg.getPhase().getIndex());
			seminar.setStatusString(arg.getPhase().getCurrentPhaseDescription());
			seminar.setTerm("#livedata");
			seminar.setTopic(arg.getTopic());
			for(int i=0; i<seminarEntries.size();i++){
				Seminar s= seminarEntries.get(i);
				if (s.getTopic().equals(seminar.getTopic())){
					seminarEntries.remove(i);
				}
			}
					
			seminarEntries.add(seminar);
		}
		
		SeminarTempStorage.setSeminars(seminarEntries);
		SeminarStorage.setSeminars(seminarEntries);
		view.render(seminarEntries);

	}

}
