package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.widget.Tile;

/**
 * Implements the home activity. It is the entry point for the user
 * and helps him to navigate through the app.
 * @author Martin
 *
 */
public class HomeActivity extends MGWTAbstractActivity {

	private final ClientFactory clientFactory;
	private HomeView view;
	
	
	/**
	 * Public Constructor. Setup HomeActivity with ClientFactory.
	 * @param clientFactory
	 */
	public HomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		this.view = null;
	}
	
	@Override 
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getHomeView();
		panel.setWidget(view);
		addTapHandlers();
	}
	
	/**
	 * Adds TapHandlers to each tile on homescreen.
	 */
	public void addTapHandlers() {
		// Adding Tile handlers
		for (final Tile tile : TileBoardManager.getTiles()) {
			tile.addTapHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (!TileBoardManager.isOrganizing()) {
						clientFactory.getPlaceController().goTo(tile.getTilePlace());
						tile.clearUpdateBubble();
					} else {
						// only custom tiles can be removed.
						if (tile.isCustomLink()) {
							TileBoardManager.removeTile(tile, view.getTileBoard());
							TileBoardManager.refreshHomeScreen(view.getTileBoard());
						}
					}
				}
			});
		}
	}
}
