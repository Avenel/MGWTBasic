package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.NewsBoardUtility;

public class NewsDetailActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	private NewsBoard currentModel;
	
	public NewsDetailActivity(ClientFactory clientFactory, String id) {
		this.clientFactory = clientFactory;
		this.currentModel = NewsBoardUtility.getNewsBoardById(Integer.valueOf(id));
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		NewsDetailView view = this.clientFactory.getNewsDetailView();
		view.setTitle(currentModel.getTitle());
		view.setContent(currentModel.getContent());
	
		panel.setWidget(view);
	}

}
