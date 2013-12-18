package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;

public class MensaActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	public MensaActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		MensaView view = this.clientFactory.getMensaView();
		panel.setWidget(view);
	}

}
