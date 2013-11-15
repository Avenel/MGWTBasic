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
		
		// setup standard stuff like margin and padding
		this.tileBoardPanel.getElement().getStyle().setMargin(0, Unit.PX);
		this.tileBoardPanel.getElement().getStyle().setPadding(0, Unit.PX);
		this.tileBoardPanel.getElement().getStyle().setProperty("listStyle", "none");
		
		// setup flexible box model
		/*
		 * 	display: -webkit-flex;
			display: -moz-flex;
			display: flex;
			-webkit-flex-flow: row wrap;
			-moz-flex-flow: row wrap;
			flex-flow: row wrap;
		 */
		this.tileBoardPanel.getElement().getStyle().setProperty("display", "-webkit-flex");
		this.tileBoardPanel.getElement().getStyle().setProperty("display", "-moz-flex");
		this.tileBoardPanel.getElement().getStyle().setProperty("display", "flex");
		
		this.tileBoardPanel.getElement().getStyle().setProperty("WebkitFlexFlow", "row wrap");
		this.tileBoardPanel.getElement().getStyle().setProperty("MozFlexFlow", "row wrap");
		this.tileBoardPanel.getElement().getStyle().setProperty("FlexFlow", "row wrap");
		
		this.tileBoardPanel.getElement().getStyle().setProperty("WebkitJustifyContent", "center");
		this.tileBoardPanel.getElement().getStyle().setProperty("WebkitAlignContent", "flex-start");
		
		
//		this.tileBoardPanel.getElement().getStyle().setProperty("display", "-webkit-box");
//		this.tileBoardPanel.getElement().getStyle().setProperty("display", "-moz-box");
//		
//		this.tileBoardPanel.getElement().getStyle().setProperty("display", "-ms-flexbox");
//	
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
