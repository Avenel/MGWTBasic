package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;

import de.hska.iwi.mgwt.demo.backend.exception.FailedRequestException;

public class IFakExceptionHandler implements UncaughtExceptionHandler {

	private final PlaceController controller;
	
	private Place lastPlace;
	
	public IFakExceptionHandler(PlaceController controller) {
		this.controller = controller;
		lastPlace = new Place() {	};
	}
	
	@Override
	public void onUncaughtException(Throwable e) {
		if (e instanceof FailedRequestException && !lastPlace.equals(controller.getWhere())) {
			Dialogs.alert("Verbindungsproblem", e.getMessage(), null);
		}
		lastPlace = controller.getWhere();
	}

	public void notifyOnPlaceChange() {
		lastPlace = new Place() { };
	}

}
