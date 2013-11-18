package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.widget.Tile;
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
		final HomeView view = this.clientFactory.getHomeView();
		panel.setWidget(view);
		
		// Adding Tile handlers
		for (final Tile tile : view.getTiles()) {
			tile.addTapHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					ChangePage.changePageTo(tile.getPageName(), clientFactory.getAnimatingActivityManager(), clientFactory.getPlaceController());
					tile.clearUpdateBubble();
				}
			});
		}
	}
	
}
