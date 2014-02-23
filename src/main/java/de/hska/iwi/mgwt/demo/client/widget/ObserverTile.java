package de.hska.iwi.mgwt.demo.client.widget;

import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

/**
 * Interface for updatable tiles.
 * @author Martin
 *
 */
public interface ObserverTile {

	/**
	 * Update the tile with the given backPanel.
	 * @param amoundOfUpdates
	 * @param backPanel
	 */
	public void update(int amoundOfUpdates, LayoutPanel backPanel);
	
}
