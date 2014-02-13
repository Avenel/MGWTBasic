package de.hska.iwi.mgwt.demo.client.activities.mensa;

import java.util.Date;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
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
		intranetConn.getMensaMenu(this, Canteen.MOLTKE, DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
		
		panel.setWidget(view);
	}

	@Override
	public void update(MensaMenu arg) {
		this.clientFactory.getMensaView().setMensaMenu(arg);
	}

}
