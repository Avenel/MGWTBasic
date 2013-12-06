package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;

public class NewsSettingsActivity extends MGWTAbstractActivity {

	private final ClientFactory clientFactory;
	private NewsSettingsView view;
	
	public NewsSettingsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.view = this.clientFactory.getNewsSettingsView();
		
		panel.setWidget(view);
	}
	
}


