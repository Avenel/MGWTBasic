package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.user.client.ui.IsWidget;

import de.hska.iwi.mgwt.demo.client.widget.TileBoard;

/**
 * View Interface for HomeView, the homescreen with tiles and searchbar.
 * @author Martin
 *
 */
public interface HomeView extends IsWidget {
	
	/**
	 * Getter method for tileBoard.
	 * @return
	 */
	public TileBoard getTileBoard();
	
}
