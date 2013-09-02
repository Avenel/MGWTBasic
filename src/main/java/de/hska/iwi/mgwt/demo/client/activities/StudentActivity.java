package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.NewsUtility;

public class StudentActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	public StudentActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		StudentView view = this.clientFactory.getStudentView();		
		panel.setWidget(view);
	}
}
