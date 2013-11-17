package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

/**
 * Inherits an amount of tiles. Arranged in a table like layout.
 * @author Martin
 *
 */
public class TileBoard implements IsWidget {

	LayoutPanel tileBoardPanel;
	
	public TileBoard() {
		this.tileBoardPanel = new LayoutPanel();
		this.tileBoardPanel.getElement().addClassName("tileBoard");
	}
	
	@Override
	public Widget asWidget() {
		return this.tileBoardPanel;
	}
	
	
	/**
	 * Adds a tile to the tileBoard
	 * @param tile
	 */
	public void add(Tile tile) {
		this.tileBoardPanel.add(tile.asWidget());
	}

}
