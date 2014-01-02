package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailPlace;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.SeminarStorage;

public class ProcessSeminarActivity extends MGWTAbstractActivity {

	private ClientFactory clientFactory;
	private ProcessSeminarView view;
	List<Seminar> seminarEntries;

	public ProcessSeminarActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getProcessSeminarView();

		seminarEntries = SeminarStorage.getSeminarList();
		
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
				ProcessDetailSeminarPlace seminarProcessDetailPlace = new ProcessDetailSeminarPlace(event.getIndex()+"");
				clientFactory.getPlaceController().goTo(seminarProcessDetailPlace);
			}

		}));

	}

}
