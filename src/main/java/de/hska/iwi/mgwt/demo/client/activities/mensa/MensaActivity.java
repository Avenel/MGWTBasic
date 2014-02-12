package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.autobean.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class MensaActivity extends MGWTAbstractActivity implements ObserverActivity<MensaMenu> {
	
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
		intranetConn.getMensaMenu(this, Canteen.MOLTKE, "2014-02-12");

//		view.setMensaMenu(intranetConn.getMensaMenu(0, null));
		
		panel.setWidget(view);
	}

	@Override
	public void update(MensaMenu arg) {
		this.clientFactory.getMensaView().setMensaMenu(arg);
		
	}

}
