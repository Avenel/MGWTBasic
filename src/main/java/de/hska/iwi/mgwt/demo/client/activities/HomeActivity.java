package de.hska.iwi.mgwt.demo.client.activities;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.News;
import de.hska.iwi.mgwt.demo.client.model.NewsUtility;

public class HomeActivity extends MGWTAbstractActivity implements ObserverActivity {
	
	private final ClientFactory clientFactory;
	
	private List<News> currentModel;
	private HomeView view;
	
	public HomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getHomeView();
		
		NewsUtility.subscribe(this);
		this.currentModel = NewsUtility.getSortedNewsList();
		
		view.render(currentModel);
		panel.setWidget(view);
		
		addHandlerRegistration(view.getList().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				News selectedNews = currentModel.get(event.getIndex());
				NewsDetailPlace newsDetailPlace = new NewsDetailPlace(selectedNews.getId());
				clientFactory.getPlaceController().goTo(newsDetailPlace);
			}
			
		}));
	}

	public List<News> getCurrentModel() {
		return currentModel;
	}

	public void setCurrentModel(List<News> currentModel) {
		this.currentModel = currentModel;
	}
	

	@Override
	public void update(Object arg) {
		this.setCurrentModel((List<News>)arg);
		view.render(currentModel);
	}
	
}
