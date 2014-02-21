package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.RegisterSeminarView.InputField;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;
import de.hska.iwi.mgwt.demo.client.storage.SeminarStorage;

/**
 * Activity to register a new Seminar.
 * @author Simon
 *
 */
public class RegisterSeminarActivity extends MGWTAbstractActivity {

	private ClientFactory clientFactory;
	private RegisterSeminarView view;
	List<String> seminarEntries;
	Seminar newSeminar;
	Storage localStorage;
	
	/**
	 * Setup the activity with a ClientFactory
	 * @param clientFactory
	 */
	public RegisterSeminarActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getRegisterSeminarView();

		seminarEntries = new ArrayList<String>();
		panel.setWidget(view);

		addHandlerRegistration(view.getRegisterButton().addTapHandler(new TapHandler() {
			

			@Override
			public void onTap(TapEvent event) {
				
				newSeminar = new Seminar();
				Map<InputField,String> input= view.getInputs();
				newSeminar.setProfessor(input.get(InputField.ProfessorField));
				newSeminar.setTopic(input.get(InputField.TopicField));
				newSeminar.setTerm(input.get(InputField.TermField));
				newSeminar.setStatus(0);
				newSeminar.setStatusString("");
				
				
				// Add to the temporary cache
				SeminarTempStorage.addSeminar(newSeminar);
				// Add to the persistent cache
				SeminarStorage.addSeminar(newSeminar);
				History.back();

			}
		}));
	}

}
