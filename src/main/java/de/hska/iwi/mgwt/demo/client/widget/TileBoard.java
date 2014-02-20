package de.hska.iwi.mgwt.demo.client.widget;

import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.orientation.OrientationChangeEvent;
import com.googlecode.mgwt.dom.client.event.orientation.OrientationChangeHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;

/**
 * Inherits an amount of tiles. Arranged in a table like layout.
 * @author Martin
 *
 */
public class TileBoard implements IsWidget {

	LayoutPanel tileBoardPanel;
	List<ClickHandler> handlers;
	int width = 0;
	
	public TileBoard() {
		this.tileBoardPanel = new LayoutPanel();
		this.tileBoardPanel.getElement().addClassName("tileBoard");
		this.tileBoardPanel.setWidth("0px");
		
		// if screen orientation changes
		MGWT.addOrientationChangeHandler(new OrientationChangeHandler(){

			@Override
			public void onOrientationChanged(OrientationChangeEvent event) {
				refreshTileBoard();
			}
	
		});
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
		refreshTileBoard();
	}
	
	/**
	 * Add list of tiles to the tileBoard.
	 * @param tiles
	 */
	public void addAll(List<Tile> tiles) {
		for (Tile tile : tiles) {
			add(tile);
		}
	}
	
	/**
	 * Removes given Tile from Panel
	 * @param tile
	 */
	public void removeTile(Tile tile) {
		this.tileBoardPanel.remove(tile.asWidget());
	}
	
	/**
	 * Refresh Tile on HomeScreen
	 */
	public void refreshTiles(List<Tile> tiles) {
		this.tileBoardPanel.clear();
		addAll(tiles);
	}
	
	/**
	 * Refresh size of TileBoard Div
	 */
	private void refreshTileBoard() {
		int maxWidth = (int) (Math.rint(Document.get().getClientWidth() / 100) * 100); 
		this.width = TileBoardManager.getTiles().size() * 100;
		
		if (this.width > maxWidth) this.width = maxWidth;
		
		this.tileBoardPanel.setWidth(String.valueOf(this.width) + "px");
	}
	
	

}
