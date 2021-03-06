package de.hska.iwi.mgwt.demo.client.activities.lecture;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.gwtphonegap.client.device.Device;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;

/**
 * Implements the lecture activity.
 * @author Martin
 *
 */
public class LectureActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	/**
	 * Public constructor. Setup lecture activity with ClientFactory.
	 * @param clientFactory
	 */
	public LectureActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		LectureView view = this.clientFactory.getLectureView();
		panel.setWidget(view);
	}

}
