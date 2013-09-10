package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;

public class LectureActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	public LectureActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		LectureView view = this.clientFactory.getLectureView();
		panel.setWidget(view);
	}

}
