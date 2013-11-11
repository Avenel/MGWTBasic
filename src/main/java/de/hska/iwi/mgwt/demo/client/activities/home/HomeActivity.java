package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailPlace;
import de.hska.iwi.mgwt.demo.client.model.News;
import de.hska.iwi.mgwt.demo.events.ChangePage;

/**
 * Implements the home activity. It is the entry point for the user
 * and helps him to navigate through the app.
 * @author Martin
 *
 */
public class HomeActivity extends MGWTAbstractActivity {

	private final ClientFactory clientFactory;
	
	
	public HomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		HomeView view = this.clientFactory.getHomeView();
		panel.setWidget(view);
		
		// Adding menue Item handlers
		addHandlerRegistration(view.getNavigation().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				ChangePage.changePageTo(event.getIndex(), clientFactory.getAnimatingActivityManager(), clientFactory.getPlaceController());
			}


		}));
	}
	
}
