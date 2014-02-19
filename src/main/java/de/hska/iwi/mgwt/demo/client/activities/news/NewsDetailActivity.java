package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.NewsBoardUtility;

/**
 * Implements an activity for a newsitem. 
 * @author Martin
 *
 */
public class NewsDetailActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	private News currentModel;
	
	/**
	 * Public constructor. Setup activity with ClientFactory and its NewsItem-ID.
	 * @param clientFactory
	 * @param id
	 */
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
