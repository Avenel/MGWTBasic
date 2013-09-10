package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.News;
import de.hska.iwi.mgwt.demo.client.model.NewsUtility;

public class NewsDetailActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	private News currentModel;
	
	public NewsDetailActivity(ClientFactory clientFactory, String id) {
		this.clientFactory = clientFactory;
		this.currentModel = NewsUtility.getNewsById(id);
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		NewsDetailView view = this.clientFactory.getNewsDetailView();
		view.setTitle(currentModel.getTitle());
		view.setContent(currentModel.getContent());
		
		view.addContentToRootTabPanel(this.clientFactory.getRootTabPanel());
		
		// Set right tab, if one pressed back button
		clientFactory.getRootTabPanel().setSelectedChild(0);
		
		panel.setWidget(view);
	}

}
