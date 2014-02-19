package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;
import de.hska.iwi.mgwt.demo.client.storage.SeminarStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;
import de.hska.iwi.mgwt.demo.client.widget.AccordionInputWidget;

public class RegisterSeminarActivity extends MGWTAbstractActivity {

	private ClientFactory clientFactory;
	private RegisterSeminarView view;
	List<String> seminarEntries;
	Seminar newSeminar;
	Storage localStorage;
	
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
				
				JSONArray currentSeminars= null;


				localStorage = Storage.getLocalStorageIfSupported();
				try{
					JSONValue value= JSONParser.parseStrict(localStorage.getItem(StorageKey.ProcessesSeminarsList.toString()));
					currentSeminars= (JSONArray)value;
				}catch (NullPointerException e){
					currentSeminars=new JSONArray();
				}
				
					
				
				newSeminar = new Seminar();
				List<String> input= view.getInputs();
				newSeminar.setProfessor(input.get(0));
				newSeminar.setTopic(input.get(1));
				newSeminar.setTerm(input.get(2));
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
