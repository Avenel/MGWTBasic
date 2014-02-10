package de.hska.iwi.mgwt.demo.client.activities.settings;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;

public class SettingsActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;

	public SettingsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		SettingsView view = this.clientFactory.getSettingsView();
		
		panel.setWidget(view);
	}
	
}
