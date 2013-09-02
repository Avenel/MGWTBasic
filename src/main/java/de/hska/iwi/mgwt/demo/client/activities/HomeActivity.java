package de.hska.iwi.mgwt.demo.client.activities;

import java.util.List;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.News;
import de.hska.iwi.mgwt.demo.client.model.NewsUtility;

public class HomeActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	
	private List<News> currentModel;
	
	public HomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		HomeView view = this.clientFactory.getHomeView();
		
		this.currentModel = NewsUtility.getSortedNewsList();
		
		view.render(currentModel);
		
		addHandlerRegistration(view.getList().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				Window.alert("event: " + event.getIndex());
			}
			
		}));
		
		panel.setWidget(view);
	}
	
}
