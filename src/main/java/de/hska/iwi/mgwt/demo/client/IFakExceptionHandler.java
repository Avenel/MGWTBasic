package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;

import de.hska.iwi.mgwt.demo.backend.exception.FailedRequestException;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaPlace;

public class IFakExceptionHandler implements UncaughtExceptionHandler {

	private final PlaceController controller;
	private final ClientFactory clientFactory;
	
	private Place lastPlace;
	
	public IFakExceptionHandler(PlaceController controller, ClientFactory clientFactory) {
		this.controller = controller;
		this.clientFactory = clientFactory;
		lastPlace = new Place() {	};
	}
	
	@Override
	public void onUncaughtException(Throwable e) {
		if (e instanceof FailedRequestException && !lastPlace.equals(controller.getWhere())) {
			Dialogs.alert("Verbindungsproblem", e.getMessage(), null);
			
			// TODO make it cleaner
			// interrupt mensa loading bar 
			if (controller.getWhere().equals(new MensaPlace())) {
				clientFactory.getMensaView().displayConnectionError();
			}
		}
		lastPlace = controller.getWhere();
	}

	public void notifyOnPlaceChange() {
		lastPlace = new Place() { };
	}

}
