package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.client.ClientFactory;

public class MensaActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	public MensaActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		MensaView view = this.clientFactory.getMensaView();
		
		// Get news of all courses
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		
		// TODO: Wenn nico den AsyncCall im master hat, wieder einbauen!
//				intranetConn.getNewsBoard(this, Course.ALL);

		view.setMensaMenu(intranetConn.getMensaMenu(0, null));
		
		panel.setWidget(view);
	}

}
